package com.aula.cerveja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/estilos")
public class EstiloController {

	@RequestMapping("/novo")
	public String novo() {
		return "estilo/CadastroEstilo";
	}
	
}