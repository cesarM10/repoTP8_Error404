package ar.edu.unju.fi.tp6.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp6.model.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Long>{
	public Cliente findByNroDocumento(Long nroDocumento);
	
}
