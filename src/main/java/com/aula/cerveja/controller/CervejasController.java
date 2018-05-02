package com.aula.cerveja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aula.cerveja.model.Cerveja;
import com.aula.cerveja.repository.Cervejas;

@Controller
@RequestMapping(value = "/cervejas")
public class CervejasController {
	
	@Autowired
	private Cervejas cervejas;
	
	@RequestMapping("/novo")
	public String novo(Cerveja cerveja) {		
		
		cervejas.findAll(); // Apagar...
		
		return "cerveja/CadastroCerveja";
	}
		
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		// Salvar no banco de dados...
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		System.out.println(">>> sku: " + cerveja.getSku());
		return "redirect:/cervejas/novo";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro() {		
		return "cerveja/cadastro-produto";
	}

}
