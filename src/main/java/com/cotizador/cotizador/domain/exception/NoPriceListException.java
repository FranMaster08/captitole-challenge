package com.cotizador.cotizador.domain.exception;

public class NoPriceListException extends RuntimeException {

    public NoPriceListException(String message) {
        super(message);
    }
}
