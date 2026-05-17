package com.lmoreno.escenariocastores.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmoreno.escenariocastores.model.Movimiento;
import com.lmoreno.escenariocastores.model.Producto;
import com.lmoreno.escenariocastores.model.TipoMovimiento;
import com.lmoreno.escenariocastores.model.Usuario;
import com.lmoreno.escenariocastores.repository.MovimientoRepository;
import com.lmoreno.escenariocastores.repository.ProductoRepository;
import com.lmoreno.escenariocastores.repository.TipoMovimientoRepository;
import com.lmoreno.escenariocastores.repository.UsuarioRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Autowired
	private TipoMovimientoRepository tipoMovimientoRepository;
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	

	public List<Producto> findAll() {
		return productoRepository.findAll();
	}
	
	public List<Producto> findAllProductosActivos() {
		List<Producto> productosActivos = new ArrayList<>();
		List<Producto> productosCompeltos = productoRepository.findAll();
		
		for (Producto producto: productosCompeltos) {
			if(producto.getEstatus() == 1) {
				productosActivos.add(producto);
			}
		}
		
		return productosActivos;
	}
	
	
	public <S extends Producto> S save(S entity) {
		return productoRepository.save(entity);
	}
	
	public Producto  findById(Integer id){
		return productoRepository.findById(id).orElse(null);
	}
	
	public Producto cambiarEstado(Integer id){
		try {
	       Producto producto = productoRepository.findById(id).orElse(null);;
	        if (producto == null) {
	            return null;
	        }

	        int nuevoEstado =  producto.getEstatus() == 1 ? 0 : 1;
	        producto.setEstatus(nuevoEstado);

	        Producto productoActualizado = productoRepository.save(producto);

	        
			return productoActualizado;
		} catch (Exception e) {
			 return null;
		}
	}
	
	
	public Producto guardarEntrada(Integer id, int entradaStock, int idUsuario){
        Producto producto = productoRepository.findById(id).orElse(null);;
        if (producto == null) {
            return null;
        }
        producto.setStock(entradaStock);
        
        Producto productoActualizado = productoRepository.save(producto);
        
        
        Movimiento movimiento = new Movimiento();
        TipoMovimiento tipoMovimiento = tipoMovimientoRepository.findById(1).orElse(null);
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        movimiento.setTipoMovimiento(tipoMovimiento);
        movimiento.setProducto(productoActualizado);
        movimiento.setUsuario(usuario);
        movimiento.setFecha(LocalDateTime.now());
        
        movimientoRepository.save(movimiento);
		return productoActualizado;
	}
	
	public Producto guardarSalida(Integer id, int salidaStock, int idUsuario){
        Producto producto = productoRepository.findById(id).orElse(null);;
        if (producto == null) {
            return null;
        }
        producto.setStock(salidaStock);
        
        Producto productoActualizado = productoRepository.save(producto);
        
        
        Movimiento movimiento = new Movimiento();
        TipoMovimiento tipoMovimiento = tipoMovimientoRepository.findById(2).orElse(null);
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        movimiento.setTipoMovimiento(tipoMovimiento);
        movimiento.setProducto(productoActualizado);
        movimiento.setUsuario(usuario);
        movimiento.setFecha(LocalDateTime.now());
        
        movimientoRepository.save(movimiento);
		return productoActualizado;
	}
	

}
