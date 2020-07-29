package com.rikazzo.rikazzo.repository;

import com.rikazzo.rikazzo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuarioRepository extends JpaRepository<Usuario, Integer> {
}
