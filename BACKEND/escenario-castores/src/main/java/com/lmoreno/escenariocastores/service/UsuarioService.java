package com.lmoreno.escenariocastores.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmoreno.escenariocastores.model.LoginRespuesta;
import com.lmoreno.escenariocastores.model.Permiso;
import com.lmoreno.escenariocastores.model.Rol;
import com.lmoreno.escenariocastores.model.Usuario;
import com.lmoreno.escenariocastores.repository.RolRepository;
import com.lmoreno.escenariocastores.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	public LoginRespuesta login(String correo, String contrasena) {

		Optional<Usuario> usuarioOpcional = usuarioRepository.findByCorreo(correo);
		if (usuarioOpcional.isEmpty()) return null;
	
		Usuario usuario = usuarioOpcional.get();
        if (!contrasena.equals(usuario.getContrasena()))return null;
   
        
        Optional<Rol> rolUsuario  = rolRepository.findById(usuario.getRol().getId_rol());
 
		if (rolUsuario.isEmpty()) return null;
		Rol rol = rolUsuario.get();
		
		List<Integer> permisosIds = new ArrayList<>();
		for (Permiso permiso : rol.getPermisos()) {
		    permisosIds.add(permiso.getId_permiso());
		}
		
		LoginRespuesta loginRespuesta = new LoginRespuesta();
		
		loginRespuesta.setUsuario(usuario);
		loginRespuesta.setPermisosIds(permisosIds);
        
		return loginRespuesta;
	}
}
