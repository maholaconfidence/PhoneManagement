package com.example.phonemanagement.dto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.jspecify.annotations.NonNull;


public record PhoneRequest(

        @NotBlank(message = "Brand name is required")
        @Size (max = 100 , message = "The brand name must not exceed 100 characters")
        String Brand,

        @NotBlank(message = "Model name is required")
        @Size (max = 100 , message = "The model must not exceed 100 characters")
        String Model,

        @NotBlank(message = "Price is required")
        @DecimalMin(value = "0.01", message = "Price must be greater then 0")
        double price,

        @Min(value = 0, message = "Stock quantity cannot be negative")
        @Column(nullable = false)
        int stockQuantity
) {


}
