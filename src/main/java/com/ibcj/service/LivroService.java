package com.ibcj.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ibcj.util.jpa.Transactional;
import com.ibcj.model.Livro;
import com.ibcj.repository.Livros;

public class LivroService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Livros livros;
	
	@Transactional
	public void salvar(Livro livro){
		livros.salvar(livro);
	}

	@Transactional
	public Livro porCodigo(Integer codigo) {
		return livros.porCodigo(codigo);
	}
	
	@Transactional
	public void remover(Livro livro) {
		livros.remover(livro);
	}
	
	@Transactional
	public List<Livro> listar() {
		return livros.listar();
	}
	
	
}
