package ar.edu.unju.fi.tp6.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp6.model.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Long>{

	public Producto findByCodigo(Long codigo);

}
