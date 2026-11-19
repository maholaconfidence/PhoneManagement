package com.example.phonemanagement.service;

import com.example.phonemanagement.dto.PhoneRequest;
import com.example.phonemanagement.dto.PhoneResponse;
import com.example.phonemanagement.entity.Phone;
import com.example.phonemanagement.repository.PhoneRepository;
import jakarta.transaction.Transactional;

import java.util.List;

public class PhoneService {
    private final PhoneRepository phoneRepository;
    public PhoneService(PhoneRepository phoneRepository){
        this.phoneRepository = phoneRepository;
    }
    //CREATE
    public PhoneResponse createPhone(PhoneRequest request){

        Phone phone = new Phone();
        phone.setBrand(request.Brand());
        phone.setModel(request.Model());
        phone.setPrice(request.price());
        Phone savedPhone = phoneRepository.save(phone);

       return  mapToResponse(savedPhone) ;
    }

    //READ ALL
    @Transactional
    public List<PhoneResponse> getAllPhones(){

        return PhoneRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }
    //READ ONE
    public  PhoneResponse getPhoneById(long id, PhoneRequest){

        Phone phone = findPhoneOrThrow(id);
        return  mapToResponse(phone);
    }

    //UPDATE
    public  PhoneResponse updatePhone(long id, PhoneRequest){
        Phone phone = findPhoneOrThrow(id);

        phone.setBrand(request.Brand());
        phone.setModel(request.Model());
        phone.setPrice(request.price());

        Phone updatedPhone = phoneRepository.save(phone);
         return  mapToResponse(updatedPhone);
    }

    //DELETE
    public  void deletePhone(long id){
        Phone phone = findPhoneOrThrow(id);

        phoneRepository.delete(phone);

    }
    private  Phone findPhoneOrThrow (long id){
        return  PhoneRepository.findBy(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Phone not found with ID: " + id
                ));


    }

    private PhoneResponse mapToResponse (Phone phone){
        return new PhoneResponse(

                phone.getId(),
                phone.getBrand(),
                phone.getModel(),
                phone.getDateManufactured(),
                phone.getPrice()
        );
    }




}
