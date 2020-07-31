package com.rikazzo.rikazzo.repository;

import com.rikazzo.rikazzo.entity.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface metodoRepository extends JpaRepository<MetodoPago, Integer> {
}
