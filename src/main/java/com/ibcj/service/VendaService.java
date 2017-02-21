package com.ibcj.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ibcj.util.jpa.Transactional;
import com.ibcj.model.Venda;
import com.ibcj.repository.Vendas;

public class VendaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Vendas vendas;
	
	@Transactional
	public void salvar(Venda venda){
		vendas.salvar(venda);
	}

	@Transactional
	public Venda porCodigo(Integer codigo) {
		return vendas.porCodigo(codigo);
	}
	
	@Transactional
	public void remover(Venda venda) {
		vendas.remover(venda);
	}
	
	@Transactional
	public List<Venda> listar() {
		return vendas.listar();
	}
}