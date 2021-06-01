package ar.edu.unju.fi.tp6.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.model.Compra;
import ar.edu.unju.fi.tp6.repository.ICompraRepository;
import ar.edu.unju.fi.tp6.service.ICompraService;

@Service("compraServiceMysql")
public class CompraServiceMysqlImp implements ICompraService{

	@Autowired
	private ICompraRepository compraRepository;
	
	@Autowired
	private Compra compra;
	
	@Override
	public void generarTablaCompra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarCompra(Compra compra) {
		compraRepository.save(compra);
		
	}

	@Override
	public List<Compra> obtenerCompras() {
		List<Compra> compras = (List<Compra>)compraRepository.findAll();
		return compras;
	}

	@Override
	public Compra getCompra() {
		return compra;
	}

	@Override
	public Optional<Compra> getCompraPorId(Long id) {
		Optional<Compra> compra = compraRepository.findById(id);
		
		return compra;
	}

	@Override
	public void eliminarCompra(Long id) {
		compraRepository.deleteById(id);
		
	}

}
