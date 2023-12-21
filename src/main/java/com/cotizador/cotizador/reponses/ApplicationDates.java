package com.cotizador.cotizador.reponses;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Builder
@Data
public class ApplicationDates {
    private LocalDateTime startDate;
    private LocalDateTime endsDate;
}
