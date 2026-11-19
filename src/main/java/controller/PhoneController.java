package controller;

import com.example.phonemanagement.dto.PhoneRequest;
import com.example.phonemanagement.dto.PhoneResponse;
import com.example.phonemanagement.service.PhoneService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/phones")

public class PhoneController {
    private final PhoneService phoneService;
    public  PhoneController(PhoneService phoneService){
        this.phoneService = phoneService;
    }
    //CREATE
    public ResponseEntity<PhoneResponse> createPhone(@Valid @RequestBody PhoneRequest request){

        PhoneResponse response = phoneService.createPhone(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
    //READ ALL
    @GetMapping
    public  ResponseEntity<List<PhoneResponse>> getAllPhones(){
        return  ResponseEntity.ok(phoneService.getAllPhones());
    }

    //READ ONE
    @GetMapping("/{id}")
    public  ResponseEntity<PhoneResponse> getPhoneById(@PathVariable long id){
        return  ResponseEntity.ok(phoneService.getPhoneById(id));
    }
    //UPDATE
    @PutMapping("/{id}")
    public  ResponseEntity<PhoneResponse> updatePhone(@PathVariable long id, @Valid @RequestBody PhoneRequest request){
        return  ResponseEntity.ok(phoneService.updatePhone(id));
    }
    //DELETE
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletePhone(@PathVariable long id){
        phoneService.deletePhone(id);
        return  ResponseEntity.noContent().build();
    }

}
