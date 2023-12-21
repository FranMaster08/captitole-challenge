package com.cotizador.cotizador.service;

import com.cotizador.cotizador.dto.PricesDto;
import com.cotizador.cotizador.entities.Prices;
import com.cotizador.cotizador.exception.NoPriceListException;
import com.cotizador.cotizador.reponses.ApplicationDates;
import com.cotizador.cotizador.reponses.PricesResponses;
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

    public PricesResponses getLatestPrice(
            PricesDto pricesDto) {
        String startDate = pricesDto.getApplicationDate().toString();
        String productId = pricesDto.getProductId();
        long brandId = pricesDto.getBrandId();

        Prices prices = pricesRepository.findPriceForProduct(startDate, productId, brandId);
        // ver errores por fechas
        if (prices == null) {
            // Lanza una excepción personalizada
            throw new NoPriceListException("Sin precio de lista");
        }

        return buildResponses(prices, pricesDto);

    }

    private PricesResponses buildResponses(Prices prices, PricesDto pricesDto) {
        PricesResponses responses = PricesResponses.builder()
                .priceList(prices.getPriceListId())
                .finalPrice(prices.getPrice())
                .applicationDates(ApplicationDates.builder()
                        .endsDate(prices.getEndDate().toLocalDateTime())
                        .startDate(prices.getStartDate().toLocalDateTime())
                        .build())
                .brandId(prices.getBrand().getId())
                .productId(prices.getProduct().getId())
                .currency(prices.getCurr())
                .applicationDate(pricesDto.getApplicationDate())
                .build();
        return responses;
    }

}
