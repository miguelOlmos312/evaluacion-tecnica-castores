package com.lmoreno.escenariocastores.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="permisos")
public class Permiso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  id_permiso;
	private String nombre;
	
	@ManyToMany(mappedBy = "permisos")
	@JsonIgnore
	private List<Rol> roles;
	
	public Permiso(String nombre, List<Rol> roles) {
		super();
		this.nombre = nombre;
		this.roles = roles;
	}

	public Permiso() {
		super();
	}


	
	public Integer getId_permiso() {
		return id_permiso;
	}

	public void setId_permiso(Integer id_permiso) {
		this.id_permiso = id_permiso;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	
	
	
}
