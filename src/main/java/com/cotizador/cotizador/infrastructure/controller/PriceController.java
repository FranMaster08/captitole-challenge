package com.cotizador.cotizador.infrastructure.controller;

import java.util.List;

import com.cotizador.cotizador.domain.interfaces.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cotizador.cotizador.dto.PricesDto;
import com.cotizador.cotizador.domain.entities.Prices;
import com.cotizador.cotizador.domain.reponses.PricesResponses;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/prices")
@Validated
public class PriceController {
    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Obtiene una lista de todos los precios.
     *
     * @return ResponseEntity con la lista de precios.
     */
    @GetMapping("/get-prices")
    public ResponseEntity<List<Prices>> getPrices() {
        return priceService.getPrices();
    }

    @PostMapping("/getLatestPrice")
    public PricesResponses getLatestPrice(
           @Valid @RequestBody PricesDto pricesDto) {
        return priceService.getLatestPrice(pricesDto);

    }

}
