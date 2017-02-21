package com.ibcj.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ibcj.interfaces.IVenda;
import com.ibcj.model.Venda;

public class Vendas implements Serializable, IVenda{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Venda> listar() {
		List<Venda> listaVenda = null;
		Query query = manager.createQuery("Select c from Venda c order by codigo");
		listaVenda = query.getResultList();
		return listaVenda;
	}

	public Venda porCodigo(Integer codigo) {
		Venda venda = manager.find(Venda.class, codigo);
		return venda;
	}

	public void salvar(Venda venda) {
		manager.merge(venda);
	}

	public void remover(Venda venda) {
		manager.remove(manager.getReference(Venda.class, venda.getCodigo()));
	}
}
