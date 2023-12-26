package com.cotizador.cotizador.infrastructure.repositories;

import com.cotizador.cotizador.domain.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

    @Query(value = "SELECT * FROM PRICES p " +
            "WHERE :timestamp BETWEEN p.start_date AND p.end_date " +
            "AND p.product_id = :productId " +
            "AND p.brand_id = :brandId " +
            "ORDER BY p.priority_id DESC " +
            "LIMIT 1", nativeQuery = true)
    Prices findPriceForProduct(@Param("timestamp") String timestamp,
                                         @Param("productId") String productId,
                                         @Param("brandId") Long brandId);
}
