package ar.edu.unju.fi.tp6.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp6.model.Cliente;
import ar.edu.unju.fi.tp6.service.IClienteService;
import ar.edu.unju.fi.tp6.service.imp.CompraServiceImp;

@Controller
public class ClienteController {
	private static final Log LOGGER = LogFactory.getLog(CompraServiceImp.class);

	@Autowired
	@Qualifier("clienteServiceMysql")
	private IClienteService clienteService;
	
	
	@GetMapping("/cliente/nuevo")
	public String getNuevoClientePage(Model model){
		model.addAttribute("cliente", clienteService.getCliente());

		return "nuevocliente";
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView agregarClientePage(@ModelAttribute("cliente")Cliente cliente) {
		ModelAndView model = new ModelAndView("clientes");
		
		clienteService.agregarCliente(cliente);
		
		model.addObject("cliente", clienteService.obtenerClientes());
		return model;
	}
	
	@GetMapping("/cliente/listado")
	public ModelAndView getClientesPage() {
		ModelAndView model = new ModelAndView("clientes");
		
		
		model.addObject("cliente",clienteService.obtenerClientes());
		
		return model;
	}
	
	//NUEVO TP7
	@GetMapping("/cliente/editar/{id}")
	public ModelAndView getClienteEditPage(@PathVariable(value = "id")Long id) {
		LOGGER.info("METODO - - EDITAR CLIENTE");
		ModelAndView model = new ModelAndView("nuevocliente");
		Optional <Cliente> cliente = clienteService.getClientePorId(id);
		
		model.addObject("cliente", cliente);
		return model;
	}
	
	@GetMapping("/cliente/eliminar/{id}")
	public ModelAndView getClienteDeletePage(@PathVariable(value = "id")Long id) {
		ModelAndView model = new ModelAndView("redirect:/cliente/listado");
		clienteService.eliminarCliente(id);
		
		return model;
	}
	
}
