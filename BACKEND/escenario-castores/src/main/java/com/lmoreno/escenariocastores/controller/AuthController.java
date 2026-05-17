package com.lmoreno.escenariocastores.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmoreno.escenariocastores.model.LoginRespuesta;
import com.lmoreno.escenariocastores.service.UsuarioService;

@RestController
@RequestMapping ("/auth/")
public class AuthController {

	
	@Autowired
	private UsuarioService usuarioService;
	

	
	@PostMapping("login")
	public ResponseEntity<LoginRespuesta> guardarEntrada(
	        @RequestBody Map<String, String> body ) {
	    try {

	    	LoginRespuesta usuarioLogeado = usuarioService.login(body.get("correo"),  body.get("contrasena"));

	        return ResponseEntity.ok(usuarioLogeado);

	    } catch (Exception e) {
	        return ResponseEntity.badRequest().build();
	    }
	}
	

}
