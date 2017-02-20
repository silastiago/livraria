package com.ibcj.interfaces;

import java.util.List;

import com.ibcj.model.Livro;


/** Esta � uma Interface que possui as assinaturas dos metodos da classe Livro,
*   
* @author silas
* @since 15-08-2016
*/

public interface ILivro {

	/** Este metodo lista todos os Livros cadastrados.
	*   
	* @return retorna a lista dos Livros cadastrados.
	*   	
	*/
	public List<Livro> listar();
	
	/** Este metodo pesquisa um Livro por seu id.
	*  	
	*  @param codigo, Este codigo � o id do Livro que voc� est� procurando.
	*  @return retorna o Livro daquele id que voc� est� pesquisando.
	*   	
	*/
	public Livro porCodigo(Integer codigo);
	
	/** Este metodo cria ou altera um Livro.
	*  	
	*  @param Livro, Este Livro � o objeto Livro que voc� ir� criar ou modificar.
	*   	
	*/
	public void salvar(Livro livro);
	
	/** Este metodo Remove um Livro.
	*  	
	*  @param Livro, Esta Livro � o objeto Livro que voc� ir� remover.
	*   	
	*/
	public void remover(Livro livro);
}