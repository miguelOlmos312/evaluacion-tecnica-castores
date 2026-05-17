package com.lmoreno.escenariocastores.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "roles")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_rol;
	private String nombre;
	
	@ManyToMany
	@JoinTable(
		name = "roles_permisos",
	    joinColumns = @JoinColumn(name = "id_rol"),
	    inverseJoinColumns = @JoinColumn(name = "id_permiso")
	)
	private List<Permiso> permisos;
	

	public Rol(String nombre, List<Permiso> permisos) {
		super();
		this.nombre = nombre;
		this.permisos = permisos;
	}


	public Rol() {
		super();
	}
	


	public Integer getId_rol() {
		return id_rol;
	}


	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Permiso> getPermisos() {
		return permisos;
	}


	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	
}
