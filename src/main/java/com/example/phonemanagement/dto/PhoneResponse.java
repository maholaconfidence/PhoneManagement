package com.example.phonemanagement.dto;

import java.util.Date;

public record PhoneResponse(
        Long id,
        String Brand,
        String Model,
        Date dateManufactured,
        double price
) {
}
