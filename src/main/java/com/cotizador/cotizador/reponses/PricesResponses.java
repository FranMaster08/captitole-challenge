package com.cotizador.cotizador.reponses;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class PricesResponses {
    private LocalDateTime applicationDate;
    private String productId;
    private long brandId;
    private long priceList;
    private double finalPrice;
    private  ApplicationDates applicationDates;
    private  String currency;
}


