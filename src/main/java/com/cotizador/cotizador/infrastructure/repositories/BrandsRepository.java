package com.cotizador.cotizador.infrastructure.repositories;

import com.cotizador.cotizador.domain.entities.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRepository extends JpaRepository<Brands, Long> {
    // Puedes agregar métodos de consulta personalizados si es necesario
}