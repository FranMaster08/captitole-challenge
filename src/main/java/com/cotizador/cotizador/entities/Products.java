package com.cotizador.cotizador.entities;
import lombok.Data;

import jakarta.persistence.*;


@Data
@Entity
@Table(name = "PRODUCTS")
public class Products {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
