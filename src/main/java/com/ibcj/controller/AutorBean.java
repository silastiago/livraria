package com.ibcj.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.ibcj.model.Autor;
import com.ibcj.service.AutorService;
import com.ibcj.util.FacesUtil;


/** Esta � uma Classe concreta que une as implementacoes das interfaces e das paginas xhtml referentes a entidade Autor.
 *   
 * @author silas
 * @since 18-08-2016
 */

@Named
@ViewScoped
public class AutorBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AutorService autorService;
	
	private Autor autor = new Autor();
	private Autor autorSelecionado;
	private List<Autor> listaAutores = new ArrayList<Autor>();

	/** Este metodo cadastra um Autor.
	 */
	public void cadastrar(){
		//Esta linha salva a entidade Autor.
		autorService.salvar(autor);
		FacesUtil.addInfoMessage("Autor Criado com sucesso");
	}
	
	public void editar(){
		//Esta linha salva a entidade Autor.
		autorService.salvar(autor);
		FacesUtil.addInfoMessage("Autor Editado com sucesso");
		
	}
	
	
	/** Este metodo Remove um Autor.
	 *  @param Autor, Este Autor � o objeto Autor que voc� ir� remover.
	 */
	public void excluir(){
		//Esta linha remove o Autor.
		autorService.remover(autorSelecionado);
		//Atualizar a lista de Autores
		autorSelecionado = null;
		listar();
	}

	/** Este metodo lista todos os Autors cadastrados.
	 * 	@return retorna a lista de todos os Autors cadastradas no sistema.
	 */
	public List<Autor> listar(){
		//Esta linha lista os Autors e joga em uma lista de Autors.
		listaAutores = autorService.listar();
		//Retorna a lista de Autors
		return listaAutores;
	}	

	public void novo(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Novo/AutorNovo.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void edicao(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Edicao/Autor.xhtml?codigo="+autorSelecionado.getCodigo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Autor getAutorSelecionado() {
		return autorSelecionado;
	}

	public void setAutorSelecionado(Autor autorSelecionado) {
		this.autorSelecionado = autorSelecionado;
	}

	public List<Autor> getListaAutores() {
		return listaAutores;
	}

	public void setListaAutores(List<Autor> listaAutores) {
		this.listaAutores = listaAutores;
	}	
}