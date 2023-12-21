package com.cotizador.cotizador.exception;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ErrorResponse {
    private Integer statusCode;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date timestamp;
    private String message;
    private String path;
    private String error;

}