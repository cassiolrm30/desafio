package br.com.desafio.interfaces;
import java.util.List;

import br.com.desafio.entities.Produto;

public interface IProdutoRepository
{
	// m�todo para incluir uma tarefa no banco de dados
	void create(Produto produto) throws Exception;

	// m�todo para incluir uma tarefa no banco de dados
	void update(Produto produto) throws Exception;

	// m�todo para incluir uma tarefa no banco de dados
	void delete(Integer id) throws Exception;

	//M�todo para consultar no banco de dados todos os usu�rios
	List<Produto> findAll() throws Exception;

	//M�todo para consultar no banco de dados 1 usu�rio
	Produto findById(Integer id) throws Exception;

	//M�todo para consultar no banco de dados 1 usu�rio
	List<Produto> find(String nome) throws Exception;
}