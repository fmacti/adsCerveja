package com.aula.cerveja.repository.helper.cerveja;

import java.util.List;

import com.aula.cerveja.model.Cerveja;
import com.aula.cerveja.repository.filter.CervejaFilter;

public interface CervejasQueries {
	public List<Cerveja> filtrar(CervejaFilter filtro);
}