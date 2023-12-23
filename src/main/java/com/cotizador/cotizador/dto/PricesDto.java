package com.cotizador.cotizador.dto;

import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.*;


@Data
public class PricesDto {
    @NotNull(message = "The application date cannot be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime applicationDate;
 
    @NotNull(message = "The productId cannot be null")
    @NotBlank(message = "The productId cannot be empty")
    @Pattern(regexp = "\\d+", message = "The productId must be numeric")
    private String productId;

    @NotNull(message = "The brandId cannot be null")
    @NotBlank(message = "The brandId cannot be empty")
    @Pattern(regexp = "\\d+", message = "The brandId must be numeric")
    private String brandId;
}
