package com.lmoreno.escenariocastores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmoreno.escenariocastores.model.Movimiento;
import com.lmoreno.escenariocastores.service.MovimientoService;

@RestController
@RequestMapping ("/movimientos/")
public class MovimientoController {

	@Autowired
	private MovimientoService movimientoService;
	
	@GetMapping("/movimientos-por-tipo-movimiento/{idTipoMovimiento}")	
	public ResponseEntity<List<Movimiento>> getMovimientosByIdTipoMovimiento(@PathVariable Integer idTipoMovimiento){
		return ResponseEntity.ok(movimientoService.findMovimientosByIdTipoMovimiento(idTipoMovimiento));
	}

	
}
