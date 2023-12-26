package com.cotizador.cotizador.domain.interfaces;

import com.cotizador.cotizador.dto.PricesDto;
import com.cotizador.cotizador.domain.entities.Prices;
import com.cotizador.cotizador.domain.reponses.PricesResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PriceService {
    ResponseEntity<List<Prices>> getPrices();
    PricesResponses getLatestPrice(PricesDto pricesDto);
}
