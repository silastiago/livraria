package com.ibcj.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.ibcj.model.Livro;
import com.ibcj.model.Venda;
import com.ibcj.service.VendaService;
import com.ibcj.util.FacesUtil;


/** Esta � uma Classe concreta que une as implementacoes das interfaces e das paginas xhtml referentes a entidade Venda.
 *   
 * @author silas
 * @since 18-08-2016
 */

@Named
@ViewScoped
public class VendaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private VendaService vendaService;
	
	private Venda venda = new Venda();
	private Venda vendaSelecionada;
	private List<Venda> listaVendas = new ArrayList<Venda>();

	/** Este metodo cadastra um Venda.
	 */
	public void cadastrar(){
		//Esta linha salva a entidade Venda.
		Livro livro = new Livro();
		livro = venda.getLivro();
		
		System.out.println("Numero de livros: " + livro.getQuantidade());
		
		//vendaService.salvar(venda);
		FacesUtil.addInfoMessage("Venda Criado com sucesso");
	}
	
	public void editar(){
		//Esta linha salva a entidade Venda.
		vendaService.salvar(venda);
		FacesUtil.addInfoMessage("Venda Editado com sucesso");
		
	}
	
	
	/** Este metodo Remove um Venda.
	 *  @param Venda, Este Venda � o objeto Venda que voc� ir� remover.
	 */
	public void excluir(){
		//Esta linha remove o Venda.
		vendaService.remover(vendaSelecionada);
		//Atualizar a lista de Vendaes
		vendaSelecionada = null;
		listar();
	}

	/** Este metodo lista todos os Vendas cadastrados.
	 * 	@return retorna a lista de todos os Vendas cadastradas no sistema.
	 */
	public List<Venda> listar(){
		//Esta linha lista os Vendas e joga em uma lista de Vendas.
		listaVendas = vendaService.listar();
		//Retorna a lista de Vendas
		return listaVendas;
	}	

	public void novo(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Novo/VendaNovo.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void edicao(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Edicao/Venda.xhtml?codigo="+vendaSelecionada.getCodigo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Venda getVendaSelecionada() {
		return vendaSelecionada;
	}

	public void setVendaSelecionada(Venda vendaSelecionada) {
		this.vendaSelecionada = vendaSelecionada;
	}

	public List<Venda> getListaVendas() {
		return listaVendas;
	}

	public void setListaVendas(List<Venda> listaVendas) {
		this.listaVendas = listaVendas;
	}	
}