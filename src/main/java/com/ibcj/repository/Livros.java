package com.ibcj.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ibcj.interfaces.ILivro;
import com.ibcj.model.Livro;

public class Livros implements Serializable, ILivro{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Livro> listar() {
		List<Livro> listaLivro = null;
		Query query = manager.createQuery("Select c from Livro c order by titulo");
		listaLivro = query.getResultList();
		return listaLivro;
	}

	public Livro porCodigo(Integer codigo) {
		Livro Livro = manager.find(Livro.class, codigo);
		return Livro;
	}

	public void salvar(Livro livro) {
		manager.merge(livro);
	}

	public void remover(Livro livro) {
		manager.remove(manager.getReference(Livro.class, livro.getCodigo()));
	}
}
