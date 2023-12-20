package com.cotizador.cotizador.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cotizador.cotizador.dto.PricesDto;
import com.cotizador.cotizador.entities.Prices;
import com.cotizador.cotizador.reponses.PricesResponses;
import com.cotizador.cotizador.service.PriceService;

@RestController
@RequestMapping("/prices")
public class PriceController {
    private final PriceService priceService;

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
            @RequestBody PricesDto pricesDto) {
        return priceService.getLatestPrice(pricesDto);

    }

}
