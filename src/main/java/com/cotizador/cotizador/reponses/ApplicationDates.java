package com.cotizador.cotizador.reponses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationDates {
    private LocalDateTime startDate;
    private LocalDateTime endsDate;
}
