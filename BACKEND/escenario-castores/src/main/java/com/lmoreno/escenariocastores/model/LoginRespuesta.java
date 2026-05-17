package com.lmoreno.escenariocastores.model;

import java.util.List;

public class LoginRespuesta {
   private Usuario usuario;
   private List<Integer> permisosIds;
   
   public LoginRespuesta(Usuario usuario, List<Integer> permisosIds) {
	super();
	this.usuario = usuario;
	this.permisosIds = permisosIds;
   }

   public LoginRespuesta() {
	super();
   }

   public Usuario getUsuario() {
	return usuario;
   }

   public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
   }

   public List<Integer> getPermisosIds() {
	return permisosIds;
   }

   public void setPermisosIds(List<Integer> permisosIds) {
	this.permisosIds = permisosIds;
   }
   
   
}
