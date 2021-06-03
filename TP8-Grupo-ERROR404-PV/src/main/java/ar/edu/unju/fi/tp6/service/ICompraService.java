package ar.edu.unju.fi.tp6.service;
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp6.model.Compra;
public interface ICompraService {
	public void generarTablaCompra();
	
	public void agregarCompra(Compra compra);
	
	public Compra getCompra();
	
	public List<Compra> obtenerCompras();
	
	public Optional<Compra> getCompraPorId(Long id);
	
	public void eliminarCompra(Long id);
	
	public List<Compra> buscarCompras(String nombre, double total);

}
