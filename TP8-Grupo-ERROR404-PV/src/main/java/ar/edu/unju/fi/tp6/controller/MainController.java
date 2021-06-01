package ar.edu.unju.fi.tp6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	/* Integrantes del Grupo Error404:
	 * Gaspar, Alvaro Emanuel
	 * Mercado, Cesar David
	 * Rodriguez, Enrique Sebastian
	 * Salas, Ivan Arnaldo
	 */
	
	@GetMapping("/home")
	public String getPageHome() {
		return "home";
	}
	
}
