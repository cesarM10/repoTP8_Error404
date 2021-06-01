package ar.edu.unju.fi.tp6.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp6.model.Cliente;

public interface IClienteService {
	public void generarTablaCliente();
	
	public void agregarCliente(Cliente cliente);
	
	public Cliente getCliente();
	
	public List<Cliente> obtenerClientes();
	
	public Optional <Cliente> getClientePorId(Long id);
	
	public void eliminarCliente(Long id);
}
