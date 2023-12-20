package com.cotizador.cotizador.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PricesDto {
    private LocalDateTime applicationDate;
    private String productId;
    private long brandId;
}
