package com.aula.cerveja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aula.cerveja.model.Cerveja;
import com.aula.cerveja.repository.Cervejas;

@Service
public class CadastroCervejaService {
	
	@Autowired
	private Cervejas cervejas;
	
	@Transactional
	public void salvar(Cerveja cerveja) {
		cervejas.save(cerveja);
	}
	
	@Transactional

	public void excluir(Long id) {
		cervejas.delete(id);		
		
	}
}
