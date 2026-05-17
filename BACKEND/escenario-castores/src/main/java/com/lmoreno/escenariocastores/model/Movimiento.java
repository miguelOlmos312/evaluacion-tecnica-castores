package com.lmoreno.escenariocastores.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "movimientos")
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  id_movimiento;

	@ManyToOne
	@JoinColumn (name = "id_tipo_movimiento")
	private TipoMovimiento tipoMovimiento;
	
	@ManyToOne
	@JoinColumn (name = "id_producto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn (name = "id_usuario")
	private Usuario usuario;
	
	private LocalDateTime fecha;

	public Movimiento(TipoMovimiento tipoMovimiento, Producto producto, Usuario usuario, LocalDateTime fecha) {
		super();
		this.tipoMovimiento = tipoMovimiento;
		this.producto = producto;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	public Movimiento() {
		super();
	}

	
	public Integer getId_movimiento() {
		return id_movimiento;
	}

	public void setId_movimiento(Integer id_movimiento) {
		this.id_movimiento = id_movimiento;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
}
