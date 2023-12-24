package com.cotizador.cotizador.service;

import com.cotizador.cotizador.domain.entities.Prices;
import com.cotizador.cotizador.infrastructure.repositories.PricesRepository;
import com.cotizador.cotizador.infrastructure.service.PriceServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PriceServiceTest {

    @Mock
    private PricesRepository pricesRepository;

    @InjectMocks
    private PriceServiceImp priceService;

    private   Prices[] pricesArray ;

    @BeforeEach
    void setUp() throws IOException {

             final AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this);
            // Lee el archivo JSON desde la carpeta de recursos
            File jsonFile = new File(getClass().getClassLoader().getResource("prices.json").getFile());

            // Utiliza ObjectMapper para convertir el JSON en un array de objetos Prices
            ObjectMapper objectMapper = new ObjectMapper();
            this.pricesArray = objectMapper.readValue(jsonFile, Prices[].class);


    }

    @Test
    void getPrices() {
    }

    @Test
    void getLatestPrice() {
    }

    @Test
    void testGetPrices() {
        try {

            // Mocking repository behavior
            when(pricesRepository.findAll()).thenReturn(List.of(pricesArray));

            // Calling the method to be tested
            ResponseEntity<List<Prices>> responseEntity = priceService.getPrices();

            // Assertions
            assertEquals(List.of(pricesArray),responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}