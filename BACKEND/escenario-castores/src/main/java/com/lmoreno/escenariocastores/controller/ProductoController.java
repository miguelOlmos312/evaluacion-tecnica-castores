package com.lmoreno.escenariocastores.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmoreno.escenariocastores.model.Producto;
import com.lmoreno.escenariocastores.service.ProductoService;

@RestController
@RequestMapping ("/productos/")
public class ProductoController {

	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public ResponseEntity<List<Producto>> getAllProductos(){
		return ResponseEntity.ok(productoService.findAll());
	}
	
	@GetMapping("productos-activos")
	public ResponseEntity<List<Producto>> getProductosActivos(){
		return ResponseEntity.ok(productoService.findAllProductosActivos());
	}
	
	@PostMapping
	public ResponseEntity<Producto> saveProducto(@RequestBody Producto producto){
		try {
			Producto productoGuardado = productoService.save(producto);
			return ResponseEntity.created(new URI("/productos/" + productoGuardado.getId_producto())).body(productoGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PatchMapping("cambiarEstatus/{id}")
	public ResponseEntity<Producto> cambiarEstatus(
	        @PathVariable Integer id) {
	    try {

	        Producto productoActualizado = productoService.cambiarEstado(id);
	        if (productoActualizado == null) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        return ResponseEntity.ok(productoActualizado);

	    } catch (Exception e) {
	        return ResponseEntity.badRequest().build();
	    }
	}
	
	@PatchMapping("guardarEntrada/{id}")
	public ResponseEntity<Producto> guardarEntrada(
	        @PathVariable Integer id,
	        @RequestBody Map<String, Integer> body ) {
	    try {

	        Producto productoActualizado =
	                productoService.guardarEntrada(id, body.get("nuevoStock"),  body.get("idUsuario"));

	        return ResponseEntity.ok(productoActualizado);

	    } catch (Exception e) {
	        return ResponseEntity.badRequest().build();
	    }
	}
	
	@PatchMapping("guardarSalida/{id}")
	public ResponseEntity<Producto> guardarSalida(
	        @PathVariable Integer id,
	        @RequestBody Map<String, Integer> body ) {
	    try {

	        Producto productoActualizado =
	                productoService.guardarSalida(id, body.get("nuevoStock"),  body.get("idUsuario"));

	        return ResponseEntity.ok(productoActualizado);

	    } catch (Exception e) {
	        return ResponseEntity.badRequest().build();
	    }
	}
}
