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
import com.ibcj.service.LivroService;
import com.ibcj.util.FacesUtil;


/** Esta � uma Classe concreta que une as implementacoes das interfaces e das paginas xhtml referentes a entidade Livro.
 *   
 * @author silas
 * @since 18-08-2016
 */

@Named
@ViewScoped
public class LivroBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private LivroService livroService;
	
	private Livro Livro = new Livro();
	private Livro livroSelecionado;
	private List<Livro> listaLivros = new ArrayList<Livro>();

	/** Este metodo cadastra um Livro.
	 */
	public void cadastrar(){
		//Esta linha salva a entidade Livro.
		livroService.salvar(Livro);
		FacesUtil.addInfoMessage("Livro Adicionado com sucesso");

	}
	
	public void editar(){
		//Esta linha salva a entidade Livro.
		livroService.salvar(Livro);
		FacesUtil.addInfoMessage("Livro Editado com sucesso");
	}
	
	
	/** Este metodo Remove um Livro.
	 *  @param Livro, Este Livro � o objeto Livro que voc� ir� remover.
	 */
	public void excluir(){
		//Esta linha remove o Livro.
		livroService.remover(livroSelecionado);
		//Atualizar a lista de Livroes
		livroSelecionado = null;
		listar();
	}

	/** Este metodo lista todos os Livros cadastrados.
	 * 	@return retorna a lista de todos os Livros cadastradas no sistema.
	 */
	public List<Livro> listar(){
		//Esta linha lista os Livros e joga em uma lista de Livros.
		listaLivros = livroService.listar();
		//Retorna a lista de Livros
		return listaLivros;
	}	

	public void novo(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Novo/LivroNovo.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void edicao(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Edicao/Livro.xhtml?codigo="+livroSelecionado.getCodigo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Livro getLivro() {
		return Livro;
	}

	public void setLivro(Livro Livro) {
		this.Livro = Livro;
	}

	public Livro getlivroSelecionado() {
		return livroSelecionado;
	}

	public void setlivroSelecionado(Livro livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}

	public List<Livro> getlistaLivros() {
		return listaLivros;
	}

	public void setlistaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}	
}