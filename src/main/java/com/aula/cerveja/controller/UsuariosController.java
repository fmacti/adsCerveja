package com.aula.cerveja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {
	
	@RequestMapping("/novo")
	public String novo() {
		return "usuario/CadastroUsuario";
	}

}
