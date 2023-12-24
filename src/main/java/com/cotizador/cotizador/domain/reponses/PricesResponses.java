package com.cotizador.cotizador.domain.reponses;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;

@Builder
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PricesResponses {
    private LocalDateTime applicationDate;
    private String productId;
    private long brandId;
    private long priceList;
    private double finalPrice;
    private ApplicationDates applicationDates;
    private String currency;
}



