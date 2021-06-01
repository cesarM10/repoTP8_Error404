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

import ar.edu.unju.fi.tp6.model.Compra;
import ar.edu.unju.fi.tp6.model.Producto;
import ar.edu.unju.fi.tp6.service.ICompraService;
import ar.edu.unju.fi.tp6.service.IProductoService;
import ar.edu.unju.fi.tp6.service.imp.CompraServiceImp;



@Controller
public class CompraController {
	private static final Log LOGGER = LogFactory.getLog(CompraServiceImp.class);
	
	@Autowired
	@Qualifier("productoServiceMysql")
	private IProductoService productoService;
	
	
	
	@Autowired
	@Qualifier("compraServiceMysql")
	private ICompraService compraService;
	
	
	@GetMapping("/compra/nuevo")
	public String getNuevaCompraPage(Model model) {
		model.addAttribute("compra", compraService.getCompra()); 
		
		
		model.addAttribute("productos", productoService.obtenerProductos());
		return "formulario-compra";
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView agregarCompraPage(@ModelAttribute("compra")Compra compra) {
		LOGGER.info("Metodo: guardar --");
		ModelAndView model = new ModelAndView("lista-compras");
		
		
		
		Producto producto = productoService.updateStockPorCodigo(compra.getProducto().getCodigo(), compra.getCantidad());
		compra.setProducto(producto);
		LOGGER.info("PASA O NO PASA --"+compra);
		
		compraService.agregarCompra(compra);
		
		model.addObject("compras", compraService.obtenerCompras());
		LOGGER.info(compraService.obtenerCompras());
		return model;
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView getCompraPage() {
		ModelAndView model = new ModelAndView("lista-compras");
		
		
		model.addObject("compras",compraService.obtenerCompras());
		LOGGER.info(compraService.obtenerCompras());
		return model;
	}
	
	// NUEVO TP7
	@GetMapping("/compra/editar/{id}")
	public ModelAndView getCompraEditPage(@PathVariable(value = "id")Long id) {
		LOGGER.info("METODO - - EDITAR");
		ModelAndView model = new ModelAndView("formulario-compra");
		Optional<Compra> compra = compraService.getCompraPorId(id);
		
		model.addObject("compra", compra);
		model.addObject ("productos", productoService.obtenerProductos());
		return model;
	}
	
	@GetMapping("/compra/eliminar/{id}")
	public ModelAndView getProductoEliminar(@PathVariable(value = "id")Long id) {
		ModelAndView model = new ModelAndView("redirect:/compra/listado");
		compraService.eliminarCompra(id);
		
		return model;
	}
	
		
}