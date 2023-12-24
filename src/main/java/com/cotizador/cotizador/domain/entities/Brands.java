package com.cotizador.cotizador.domain.entities;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "BRANDS")
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
