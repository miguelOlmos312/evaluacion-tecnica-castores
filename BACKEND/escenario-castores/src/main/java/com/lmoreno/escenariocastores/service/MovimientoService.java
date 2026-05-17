package com.lmoreno.escenariocastores.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmoreno.escenariocastores.model.Movimiento;
import com.lmoreno.escenariocastores.repository.MovimientoRepository;

@Service
public class MovimientoService {
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	
	public List<Movimiento> findMovimientosByIdTipoMovimiento(Integer tipoMovimiento) {
		List<Movimiento> movimientos = new ArrayList<>();
		List<Movimiento> movimientosCompeltos = movimientoRepository.findAll();
		
		for (Movimiento movimiento: movimientosCompeltos) {
			if(movimiento.getTipoMovimiento().getId_tipo_movimiento() == tipoMovimiento) {
				movimientos.add(movimiento);
			}
		}
		
		return movimientos;
	}
	
	
}
