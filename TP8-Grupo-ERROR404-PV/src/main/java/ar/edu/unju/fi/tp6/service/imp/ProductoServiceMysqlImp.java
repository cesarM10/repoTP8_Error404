package ar.edu.unju.fi.tp6.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.model.Producto;
import ar.edu.unju.fi.tp6.repository.IProductoRepository;
import ar.edu.unju.fi.tp6.service.IProductoService;

@Service("productoServiceMysql")
public class ProductoServiceMysqlImp implements IProductoService{

	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private Producto producto;
	
	@Override
	public void generarTablaProducto() {
		
		
	}

	@Override
	public void agregarProducto(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public Producto ultimoProducto() {
		List<Producto> productos = (List<Producto>) productoRepository.findAll();
		Producto producto = productos.get(productos.size()-1);
		return producto;
	}

	@Override
	public List<Producto> obtenerProductos() {
		List<Producto> productos = (List<Producto>) productoRepository.findAll();
		
		return productos;
	}

	@Override
	public Producto updateStockPorCodigo(Long codigo, int cantidad) {
		Producto producto = productoRepository.findByCodigo(codigo);
		
		producto.setStock(producto.getStock()-cantidad);
		productoRepository.save(producto);
	
		return producto;
	}

	@Override
	public Producto getProducto() {
		return producto;
	}

	@Override
	public void eliminarProducto(Long codigo) {
		productoRepository.deleteById(codigo);
		
	}

	@Override
	public Producto getProductoPorCodigo(Long codigo) {
		Producto producto = productoRepository.findByCodigo(codigo);
		return producto;
	}


}
