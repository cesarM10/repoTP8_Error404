package ar.edu.unju.fi.tp6.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.model.Compra;
import ar.edu.unju.fi.tp6.model.Producto;
import ar.edu.unju.fi.tp6.service.ICompraService;
import ar.edu.unju.fi.tp6.util.TablaCompra;

@Service("compraUtilService")
public class CompraServiceImp implements ICompraService{
	private static final Log LOGGER = LogFactory.getLog(CompraServiceImp.class);
	private List<Compra> compraList = new ArrayList<Compra>();
	
	@Autowired
	private Compra compra;
	
	@Override
	public void generarTablaCompra() {
		compraList = TablaCompra.listaCompras;
		compraList.add(new Compra(1L, new Producto(1L,"Procesador Core i9",298999.99,"INTEL",100),1));
		LOGGER.info("METHOD: generarTablaCompra - creo primera compra por defecto" + compraList.get(compraList.size()-1));

	}

	@Override
	public void agregarCompra(Compra compra) {
		compraList.add(compra);
		LOGGER.info("METHOD: agregarCompra - se agrego un objeto Compra a la lista ->" + compraList.get(compraList.size()-1));

	}

	@Override
	public List<Compra> obtenerCompras() {
		LOGGER.info("METHOD: obtenerCompras - se recupero la lista de Objeto Compra");

		return compraList;
	}

	@Override
	public Compra getCompra() {
		return compra;
	}

	@Override
	public Optional<Compra> getCompraPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCompra(Long id) {
		// TODO Auto-generated method stub
		
	}

}
