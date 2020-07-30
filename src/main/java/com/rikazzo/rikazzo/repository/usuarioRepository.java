package com.rikazzo.rikazzo.repository;

import com.rikazzo.rikazzo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface usuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM usuario WHERE email= :email", nativeQuery = true)
    Usuario findByEmail(String email);

}
