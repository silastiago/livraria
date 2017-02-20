package com.ibcj.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ibcj.interfaces.IAutor;
import com.ibcj.model.Autor;

public class Autores implements Serializable, IAutor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Autor> listar() {
		List<Autor> listaAutor = null;
		Query query = manager.createQuery("Select c from Autor c order by nome");
		listaAutor = query.getResultList();
		return listaAutor;
	}

	public Autor porCodigo(Integer codigo) {
		Autor autor = manager.find(Autor.class, codigo);
		return autor;
	}

	public void salvar(Autor autor) {
		manager.merge(autor);
	}

	public void remover(Autor autor) {
		manager.remove(manager.getReference(Autor.class, autor.getCodigo()));
	}
}
