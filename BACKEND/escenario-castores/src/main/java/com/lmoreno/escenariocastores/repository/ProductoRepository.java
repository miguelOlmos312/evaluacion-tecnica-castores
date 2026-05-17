package com.lmoreno.escenariocastores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmoreno.escenariocastores.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
