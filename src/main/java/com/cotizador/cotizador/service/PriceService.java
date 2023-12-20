package com.cotizador.cotizador.service;

import com.cotizador.cotizador.dto.PricesDto;
import com.cotizador.cotizador.entities.Prices;
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
          PricesDto pricesDto
    ) {
        String startDate = pricesDto.getApplicationDate().toString();
        String productId = pricesDto.getProductId();
        long brandId = pricesDto.getBrandId();

        Prices prices = pricesRepository.findPriceForProduct(startDate, productId, brandId);
        PricesResponses responses = new PricesResponses();
        responses.setPriceList(prices.getPriceListId());
        responses.setFinalPrice(prices.getPrice());
        ApplicationDates applicationDates = new ApplicationDates();
        applicationDates.setEndsDate( prices.getEndDate().toLocalDateTime());
        applicationDates.setStartDate(prices.getStartDate().toLocalDateTime());
        responses.setApplicationDates(applicationDates);
        responses.setBrandId(prices.getBrand().getId());
        responses.setProductId(prices.getProduct().getId());
        responses.setCurrency(prices.getCurr());
        responses.setApplicationDate(pricesDto.getApplicationDate());
        // Procesa la lista de resultados como sea necesario
        return responses;
    }

}
