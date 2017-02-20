package com.ibcj.interfaces;

import java.util.List;

import com.ibcj.model.Autor;


/** Esta � uma Interface que possui as assinaturas dos metodos da classe Autor,
*   
* @author silas
* @since 15-08-2016
*/

public interface IAutor {

	/** Este metodo lista todos os Autors cadastrados.
	*   
	* @return retorna a lista dos Autors cadastrados.
	*   	
	*/
	public List<Autor> listar();
	
	/** Este metodo pesquisa um Autor por seu id.
	*  	
	*  @param codigo, Este codigo � o id do Autor que voc� est� procurando.
	*  @return retorna o Autor daquele id que voc� est� pesquisando.
	*   	
	*/
	public Autor porCodigo(Integer codigo);
	
	/** Este metodo cria ou altera um Autor.
	*  	
	*  @param Autor, Este Autor � o objeto Autor que voc� ir� criar ou modificar.
	*   	
	*/
	public void salvar(Autor autor);
	
	/** Este metodo Remove um Autor.
	*  	
	*  @param Autor, Esta Autor � o objeto Autor que voc� ir� remover.
	*   	
	*/
	public void remover(Autor autor);
}