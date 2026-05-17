package com.lmoreno.escenariocastores.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tipos_movimientos")
public class TipoMovimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo_movimiento;
	
	private String nombre;

	public TipoMovimiento(String nombre) {
		super();
		this.nombre = nombre;
	}

	public TipoMovimiento() {
		super();
	}

	public Integer getId_tipo_movimiento() {
		return id_tipo_movimiento;
	}

	public void setId_tipo_movimiento(Integer id_tipo_movimiento) {
		this.id_tipo_movimiento = id_tipo_movimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
