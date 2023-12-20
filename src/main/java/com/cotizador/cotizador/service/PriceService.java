package com.cotizador.cotizador.service;

import com.cotizador.cotizador.entities.Prices;
import com.cotizador.cotizador.repositories.PricesRepository;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    private final PricesRepository pricesRepository;

    public PriceService(PricesRepository priceRepository) {
        this.pricesRepository = priceRepository;
    }

    public ResponseEntity<List<Prices>> getPrices() {
        List<Prices> priceList = pricesRepository.findAll();
        return ResponseEntity.ok(priceList);
    }

}
