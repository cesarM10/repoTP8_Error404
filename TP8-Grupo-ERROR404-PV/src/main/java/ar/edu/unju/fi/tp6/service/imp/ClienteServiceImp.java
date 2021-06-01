package ar.edu.unju.fi.tp6.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.model.Cliente;
import ar.edu.unju.fi.tp6.service.IClienteService;
import ar.edu.unju.fi.tp6.util.TablaCliente;

@Service("clienteUtilService")
public class ClienteServiceImp implements IClienteService {
	
	private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);
	private List<Cliente> clienteList = new ArrayList<Cliente>();
	
	@Autowired
	private Cliente cliente;
	
	@Override
	public void generarTablaCliente() {
		clienteList = TablaCliente.listaClientes;
		/*clienteList.add(new Cliente("DNI",1234L,"Cesar Mercado","cesarm10@gmail.com","01234",LocalDate.of(1992, 04, 10),3886,617729,LocalDate.of(2021, 03, 17)));
		clienteList.add(new Cliente("Pasaporte",9987L,"Enrique Rodriguez","enrique@gmail.com","9122018",LocalDate.of(1994, 07, 3),388,765234,LocalDate.of(2020, 01, 10)));
		clienteList.add(new Cliente("DNI",5467L,"Ivan Salas","ivan123@gmail.com","pass123",LocalDate.of(1997, 12, 1),355,543643,LocalDate.of(2021, 05, 10)));
		clienteList.add(new Cliente("Pasaporte",6744L,"Gaspar Alvaro","alvaro678@gmail.com","P677ss",LocalDate.of(1995, 01, 13),399,56246,LocalDate.of(2018, 12, 9)));*/
		LOGGER.info("METHOD: generarTablaCliente - creo primer cliente por defecto" + clienteList.get(clienteList.size()-1));

	}

	@Override
	public void agregarCliente(Cliente cliente) {
		// agrego un cliente a la lista de clientes
		
		clienteList.add(cliente);
		LOGGER.info("METHOD: agregarCliente - se agrego un objeto Cliente a la lista ->" + clienteList.get(clienteList.size()-1));

	}

	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return cliente;
	}
	
	@Override
	public List<Cliente> obtenerClientes() {
		LOGGER.info("METHOD: obtenerClientes - se recupero la lista de Objeto Cliente");
		
		return clienteList;
	}

	@Override
	public Optional<Cliente> getClientePorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCliente(Long id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
