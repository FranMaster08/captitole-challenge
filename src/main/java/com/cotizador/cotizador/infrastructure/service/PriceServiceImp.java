package com.cotizador.cotizador.infrastructure.service;

import com.cotizador.cotizador.dto.PricesDto;
import com.cotizador.cotizador.domain.entities.Prices;
import com.cotizador.cotizador.domain.exception.NoPriceListException;
import com.cotizador.cotizador.domain.interfaces.PriceService;
import com.cotizador.cotizador.domain.reponses.ApplicationDates;
import com.cotizador.cotizador.domain.reponses.PricesResponses;
import com.cotizador.cotizador.infrastructure.repositories.PricesRepository;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImp implements PriceService {
    private final PricesRepository pricesRepository;

    public PriceServiceImp(PricesRepository priceRepository) {
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
        long brandId = Long.parseLong(pricesDto.getBrandId());
        Prices prices = pricesRepository.findPriceForProduct(startDate, productId, brandId);
        if (prices == null) {
            throw new NoPriceListException(
                    String.format("No price list found for Product '%s', Brand '%d', and Date '%s'", productId, brandId,
                            startDate));
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
