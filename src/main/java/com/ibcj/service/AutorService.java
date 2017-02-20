package com.ibcj.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ibcj.util.jpa.Transactional;
import com.ibcj.model.Autor;
import com.ibcj.repository.Autores;

public class AutorService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Autores autores;
	
	@Transactional
	public void salvar(Autor autor){
		autores.salvar(autor);
	}

	@Transactional
	public Autor porCodigo(Integer codigo) {
		return autores.porCodigo(codigo);
	}
	
	@Transactional
	public void remover(Autor autor) {
		autores.remover(autor);
	}
	
	@Transactional
	public List<Autor> listar() {
		return autores.listar();
	}
	
	
}
