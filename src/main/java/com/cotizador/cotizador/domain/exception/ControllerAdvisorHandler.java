package com.cotizador.cotizador.domain.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerAdvisorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex,
            WebRequest request) {

        ErrorResponse message = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getBindingResult().getFieldError().getDefaultMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST.getReasonPhrase());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ HttpMessageNotReadableException.class })
    public ResponseEntity<ErrorResponse> handleBadRequestException(HttpMessageNotReadableException ex,
            WebRequest request) {
        String errorMessage = ex.getMessage();
        if (ex.getMessage().matches(".*DateTimeParseException.*")) {
            errorMessage = "Invalid Aplication Date";
        }
        ErrorResponse message = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                errorMessage,
                request.getDescription(false),
                HttpStatus.BAD_REQUEST.getReasonPhrase());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.Gone.class)
    public ResponseEntity<ErrorResponse> handleGoneException(HttpClientErrorException ex, WebRequest request) {

        ErrorResponse message = new ErrorResponse(
                HttpStatus.GONE.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.GONE.getReasonPhrase());

        return new ResponseEntity<>(message, HttpStatus.GONE);
    }

    @ExceptionHandler(NoPriceListException.class)
    public ResponseEntity<ErrorResponse> handleNoPriceListException(NoPriceListException ex, WebRequest request) {

        ErrorResponse message = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.NOT_FOUND.getReasonPhrase());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpServerErrorException(HttpServerErrorException exception,
            WebRequest request) throws JsonProcessingException {

        ErrorResponse message = ErrorResponse.builder()
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(new Date())
                .path(request.getDescription(false))
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
