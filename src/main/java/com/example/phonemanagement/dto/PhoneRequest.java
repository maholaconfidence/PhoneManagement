package com.example.phonemanagement.dto;
import jakarta.validation.constraints.*;

import java.util.Date;


public record PhoneRequest(

        @NotBlank(message = "Brand name is required")
        @Size (max = 100 , message = "The brand name must not exceed 100 characters")
        String Brand,

        @NotBlank(message = "Model name is required")
        @Size (max = 100 , message = "The model must not exceed 100 characters")
        String Model,

        @NotBlank(message = "Price is required")
        @DecimalMin(value = "0.01", message = "Price must be greater then 0")
        double Price,

        @NotNull(message = "Manufactured date must not be null")
        @PastOrPresent(message = "Manufactured date cannot be in the future")
         Date Manufactured


) {


}
