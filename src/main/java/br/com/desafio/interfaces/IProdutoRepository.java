package br.com.desafio.interfaces;
import java.util.List;

import br.com.desafio.entities.Produto;

public interface IProdutoRepository
{
	// método para incluir uma tarefa no banco de dados
	void create(Produto produto) throws Exception;

	// método para incluir uma tarefa no banco de dados
	void update(Produto produto) throws Exception;

	// método para incluir uma tarefa no banco de dados
	void delete(Integer id) throws Exception;

	//Método para consultar no banco de dados todos os usuários
	List<Produto> findAll() throws Exception;

	//Método para consultar no banco de dados 1 usuário
	Produto findById(Integer id) throws Exception;

	//Método para consultar no banco de dados 1 usuário
	List<Produto> find(String nome) throws Exception;
}