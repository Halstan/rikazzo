package com.rikazzo.rikazzo.repository;

import com.rikazzo.rikazzo.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ventaRepository extends JpaRepository<Venta, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Venta SET state = 'CANCELADA' WHERE id_venta = :id", nativeQuery = true)
    void desactivateVenta(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update ropa set cantidad = cantidad - :cant where id_prenda = :id_prenda", nativeQuery = true)
    void makeVenta(@Param("cant") Integer cantidad, @Param("id_prenda") Integer id_prenda);
}
