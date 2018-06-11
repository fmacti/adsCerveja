package com.aula.cerveja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aula.cerveja.model.Cerveja;
import com.aula.cerveja.model.Origem;
import com.aula.cerveja.model.Sabor;
import com.aula.cerveja.repository.Cervejas;
import com.aula.cerveja.repository.Estilos;
import com.aula.cerveja.repository.filter.CervejaFilter;
import com.aula.cerveja.service.CadastroCervejaService;

@Controller
@RequestMapping(value = "/cervejas")
public class CervejasController {
		
	@Autowired
	private Estilos estilos;
	
	@Autowired
	private CadastroCervejaService cadastroCervejaService;
	
	@Autowired
	private Cervejas cervejas;
				
	@RequestMapping("/novo")
	public ModelAndView novo(Cerveja cerveja) {	
		
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}
		
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}	
		
		cadastroCervejaService.salvar(cerveja);
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");				
			
		return new ModelAndView("redirect:/cervejas/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(CervejaFilter cervejaFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("sabores", Sabor.values());
		mv.addObject("origens", Origem.values());		

		mv.addObject("cervejas", cervejas.filtrar(cervejaFilter));
		return mv;
	}
	
	@GetMapping("/excluir/{codigo}")
	public ModelAndView excluir(@PathVariable("codigo") Long codigo) {
		
		cadastroCervejaService.excluir(codigo);
		
		return new ModelAndView("redirect:/cervejas/");

	}
}
