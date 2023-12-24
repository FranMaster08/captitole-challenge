package com.cotizador.cotizador.controller;

import com.cotizador.cotizador.dto.PricesDto;

import com.cotizador.cotizador.reponses.ApplicationDates;
import com.cotizador.cotizador.reponses.PricesResponses;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@WebAppConfiguration
class PriceControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Description("Test get all Prices is OK")
    void getAllPrices() throws Exception {
        MvcResult mockMvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/prices/get-prices")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        assertEquals(200, mockMvcResult.getResponse().getStatus());
    }


    @Test
    @Description("Test getLatestPrice when june 14, 2020 at 10:00:00")
    void getLastPrices1() throws Exception {
        PricesDto pricesDto = PricesDto.builder()
                .applicationDate(LocalDateTime.parse("2020-06-14T10:00:00"))
                .productId("35455")
                .brandId("1").build();

        var response = this.sendRequest(pricesDto);
        PricesResponses expectedResponse = PricesResponses.builder()
                .applicationDate(LocalDateTime.parse("2020-06-14T10:00:00"))
                .productId("35455")
                .brandId(1L)
                .priceList(1L)
                .finalPrice(35.50)
                .currency("EUR")
                .applicationDates(
                        ApplicationDates.builder()
                                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                                .endsDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                                .build()
                )
                .build();
        assertEquals(response , expectedResponse);
    }

    @Test
    @Description("Test getLatestPrice when june 14, 2020 at 16:00:00")
    void getLastPrices2() throws Exception {
        PricesDto pricesDto = PricesDto.builder()
                .applicationDate(LocalDateTime.parse("2020-06-14T16:00:00"))
                .productId("35455")
                .brandId("1").build();

        var response = this.sendRequest(pricesDto);
        PricesResponses expectedResponse = PricesResponses.builder()
                .applicationDate(LocalDateTime.parse("2020-06-14T16:00:00"))
                .productId("35455")
                .brandId(1L)
                .priceList(2L)
                .finalPrice(25.45)
                .currency("EUR")
                .applicationDates(
                        ApplicationDates.builder()
                                .startDate(LocalDateTime.parse("2020-06-14T15:00:00"))
                                .endsDate(LocalDateTime.parse("2020-06-14T18:30:00"))
                                .build()
                )
                .build();
        assertEquals(response , expectedResponse);
    }

    @Test
    @Description("Test getLatestPrice when june 14, 2020 at 21:00:00")
    void getLastPrices3() throws Exception {
        PricesDto pricesDto = PricesDto.builder()
                .applicationDate(LocalDateTime.parse("2020-06-14T21:00:00"))
                .productId("35455")
                .brandId("1").build();

        var response = this.sendRequest(pricesDto);
        PricesResponses expectedResponse = PricesResponses.builder()
                .applicationDate(LocalDateTime.parse("2020-06-14T21:00:00"))
                .productId("35455")
                .brandId(1L)
                .priceList(1L)
                .finalPrice(35.50)
                .currency("EUR")
                .applicationDates(
                        ApplicationDates.builder()
                                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                                .endsDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                                .build()
                )
                .build();
        assertEquals(response , expectedResponse);
    }

    @Test
    @Description("Test getLatestPrice when june 15, 2020 at 10:00:00")
    void getLastPrices4() throws Exception {
        PricesDto pricesDto = PricesDto.builder()
                .applicationDate(LocalDateTime.parse("2020-06-15T10:00:00"))
                .productId("35455")
                .brandId("1").build();

        var response = this.sendRequest(pricesDto);
        PricesResponses expectedResponse = PricesResponses.builder()
                .applicationDate(LocalDateTime.parse("2020-06-15T10:00:00"))
                .productId("35455")
                .brandId(1L)
                .priceList(3L)
                .finalPrice(30.50)
                .currency("EUR")
                .applicationDates(
                        ApplicationDates.builder()
                                .startDate(LocalDateTime.parse("2020-06-15T00:00:00"))
                                .endsDate(LocalDateTime.parse("2020-06-15T11:00:00"))
                                .build()
                )
                .build();
        assertEquals(response , expectedResponse);
    }

    @Test
    @Description("Test getLatestPrice when june 16, 2020 at 21:00:00")
    void getLastPrices5() throws Exception {
        PricesDto pricesDto = PricesDto.builder()
                .applicationDate(LocalDateTime.parse("2020-06-16T21:00:00"))
                .productId("35455")
                .brandId("1").build();

        var response = this.sendRequest(pricesDto);
        PricesResponses expectedResponse = PricesResponses.builder()
                .applicationDate(LocalDateTime.parse("2020-06-16T21:00:00"))
                .productId("35455")
                .brandId(1L)
                .priceList(4L)
                .finalPrice(38.95)
                .currency("EUR")
                .applicationDates(
                        ApplicationDates.builder()
                                .startDate(LocalDateTime.parse("2020-06-15T16:00:00"))
                                .endsDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                                .build()
                )
                .build();
        assertEquals(response , expectedResponse);
    }

    private PricesResponses sendRequest(PricesDto pricesDto) throws Exception {
        var result =  mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/prices/getLatestPrice")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapToJson(pricesDto)))
                .andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String jsonResponse = result.getResponse().getContentAsString();
        return objectMapper.readValue(jsonResponse, PricesResponses.class);
    }

    private void assertResponseAndStatus(PricesResponses response,  PricesResponses expectedContent) {
        assertEquals(expectedContent, response);
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        try {
            ObjectMapper om = new ObjectMapper();
            om.registerModule(new JavaTimeModule());

            // convert object to json
            return om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
