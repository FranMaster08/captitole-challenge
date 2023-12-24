package com.cotizador.cotizador.interfaces;

import com.cotizador.cotizador.dto.PricesDto;
import com.cotizador.cotizador.entities.Prices;
import com.cotizador.cotizador.reponses.PricesResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PriceService {
    ResponseEntity<List<Prices>> getPrices();
    PricesResponses getLatestPrice(PricesDto pricesDto);
}
