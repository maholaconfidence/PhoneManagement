package com.example.phonemanagement.repository;

import com.example.phonemanagement.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {


}
