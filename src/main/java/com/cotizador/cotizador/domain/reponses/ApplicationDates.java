package com.cotizador.cotizador.domain.reponses;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ApplicationDates {
    private LocalDateTime startDate;
    private LocalDateTime endsDate;

}
