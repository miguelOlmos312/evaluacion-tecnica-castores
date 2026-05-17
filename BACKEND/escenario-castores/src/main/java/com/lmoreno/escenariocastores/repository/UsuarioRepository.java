package com.lmoreno.escenariocastores.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lmoreno.escenariocastores.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
    @Query(value = "SELECT * FROM usuarios WHERE correo = :correo", nativeQuery = true)
    Optional<Usuario> findByCorreo(@Param("correo") String correo);
	
}
