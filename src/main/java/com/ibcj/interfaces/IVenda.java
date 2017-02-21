package com.ibcj.interfaces;

import java.util.List;

import com.ibcj.model.Venda;


/** Esta � uma Interface que possui as assinaturas dos metodos da classe Venda,
*   
* @author silas
* @since 15-08-2016
*/

public interface IVenda {

	/** Este metodo lista todos os Vendas cadastrados.
	*   
	* @return retorna a lista dos Vendas cadastrados.
	*   	
	*/
	public List<Venda> listar();
	
	/** Este metodo pesquisa um Venda por seu id.
	*  	
	*  @param codigo, Este codigo � o id do Venda que voc� est� procurando.
	*  @return retorna o Venda daquele id que voc� est� pesquisando.
	*   	
	*/
	public Venda porCodigo(Integer codigo);
	
	/** Este metodo cria ou altera um Venda.
	*  	
	*  @param Venda, Este Venda � o objeto Venda que voc� ir� criar ou modificar.
	*   	
	*/
	public void salvar(Venda venda);
	
	/** Este metodo Remove um Venda.
	*  	
	*  @param Venda, Esta Venda � o objeto Venda que voc� ir� remover.
	*   	
	*/
	public void remover(Venda venda);
}