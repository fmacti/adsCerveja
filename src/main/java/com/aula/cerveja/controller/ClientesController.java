package com.aula.cerveja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/clientes")
public class ClientesController {
	
	@RequestMapping("/novo")
	public String novo() {
		return "cliente/CadastroCliente";
	}

}
