package br.com.desafio.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.entities.Produto;
import br.com.desafio.factories.ConnectionFactory;
import br.com.desafio.helpers.DateHelper;
import br.com.desafio.interfaces.IProdutoRepository;

public class ProdutoRepository implements IProdutoRepository
{
	@Override
	public void create(Produto produto) throws Exception
	{
		// abrindo uma conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// Escrevendo uma query SQL para execução no banco de dados
		PreparedStatement statement = connection.prepareStatement(
				"insert into produto(nome, datavalidade, quantidade, descricao, preco) values(?, ?, ?, ?, ?)");

		statement.setString(1, produto.getNome());
		statement.setString(2, DateHelper.formatToString(produto.getDataValidade()));
		statement.setInt(3, produto.getQuantidade());
		statement.setString(4, produto.getDescricao());
		statement.setDouble(5, produto.getPreco());
		statement.execute();

		connection.close();
	}

	@Override
	public void update(Produto produto) throws Exception
	{
		Connection connection = ConnectionFactory.getConnection();

		// Escrevendo uma query SQL para execução no banco de dados
		PreparedStatement statement = connection.prepareStatement(
				"update produto set nome=?, datavalidade=?, quantidade=?, descricao=?, preco=? where idproduto = ?");

		statement.setString(1, produto.getNome());
		statement.setString(2, DateHelper.formatToString(produto.getDataValidade()));
		statement.setInt(3, produto.getQuantidade());
		statement.setString(4, produto.getDescricao());
		statement.setDouble(5, produto.getPreco());
		statement.setDouble(6, produto.getIdProduto());
		statement.execute();
		connection.close();
	}

	@Override
	public void delete(Integer id) throws Exception
	{
		Connection connection = ConnectionFactory.getConnection();

		// Escrevendo uma query SQL para execução no banco de dados
		PreparedStatement statement = connection.prepareStatement("delete from produto where idproduto = ?");
		statement.setInt(1, id);
		statement.execute();
		connection.close();
	}

	@Override
	public List<Produto> findAll() throws Exception
	{
		Connection connection = ConnectionFactory.getConnection();

		// Escrevendo uma query SQL para consultar as produtos
		PreparedStatement statement = connection.prepareStatement("select * from produto order by nome");

		// executando e lendo o resultado da consulta
		ResultSet resultSet = statement.executeQuery();

		// criando uma lista de produtos vazia
		List<Produto> lista = new ArrayList<Produto>();

		// lendo cada resultado obtido do SQL
		while (resultSet.next())
		{
			Produto produto = new Produto();

			produto.setIdProduto(resultSet.getInt("idproduto"));
			produto.setNome(resultSet.getString("nome"));
			produto.setDataValidade(DateHelper.formatToDate(resultSet.getString("datavalidade")));
			produto.setQuantidade(resultSet.getInt("quantidade"));
			produto.setPreco(resultSet.getDouble("preco"));
			produto.setDescricao(resultSet.getString("descricao"));
			lista.add(produto); // adicionando na lista
		}
		connection.close();
		return lista;
	}

	@Override
	public Produto findById(Integer idProduto) throws Exception
	{
		Connection connection = ConnectionFactory.getConnection();

		// Escrevendo uma query SQL para consultar as produtos
		PreparedStatement statement = connection.prepareStatement("select * from produto where idproduto = ?");
		statement.setInt(1, idProduto);

		// executando e lendo o resultado da consulta
		ResultSet resultSet = statement.executeQuery();
		Produto produto = null;

		// lendo cada resultado obtido do SQL
		if (resultSet.next())
		{
			produto = new Produto();
			produto.setIdProduto(resultSet.getInt("idproduto"));
			produto.setNome(resultSet.getString("nome"));
			produto.setDataValidade(DateHelper.formatToDate(resultSet.getString("datavalidade")));
			produto.setQuantidade(resultSet.getInt("quantidade"));
			produto.setPreco(resultSet.getDouble("preco"));
			produto.setDescricao(resultSet.getString("descricao"));
		}
		connection.close();
		return produto; 
	}

	@Override
	public List<Produto> find(String nome) throws Exception
	{
		Connection connection = ConnectionFactory.getConnection();

		// Escrevendo uma query SQL para consultar as produtos
		PreparedStatement statement = connection.prepareStatement("select * from produto where upper(nome) = ? order by nome");
		statement.setString(1, nome.toUpperCase());

		// executando e lendo o resultado da consulta
		ResultSet resultSet = statement.executeQuery();

		// criando uma lista de produtos vazia
		List<Produto> lista = new ArrayList<Produto>();

		// lendo cada resultado obtido do SQL
		while (resultSet.next())
		{
			Produto produto = new Produto();
			produto.setIdProduto(resultSet.getInt("idproduto"));
			produto.setNome(resultSet.getString("nome"));
			produto.setDataValidade(DateHelper.formatToDate(resultSet.getString("datavalidade")));
			produto.setQuantidade(resultSet.getInt("quantidade"));
			produto.setPreco(resultSet.getDouble("preco"));
			produto.setDescricao(resultSet.getString("descricao"));
			lista.add(produto);
		}
		connection.close();
		return lista;
	}
}