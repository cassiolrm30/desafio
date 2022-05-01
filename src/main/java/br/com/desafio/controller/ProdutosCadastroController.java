package br.com.desafio.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import br.com.desafio.entities.Produto;
import br.com.desafio.helpers.DateHelper;
import br.com.desafio.models.ProdutoCadastroModel;
import br.com.desafio.repositories.ProdutoRepository;

@Controller
public class ProdutosCadastroController
{
	// método para abrir a página de cadastro de tarefa
	@RequestMapping(value = "/produtos-cadastro")
	public ModelAndView cadastro()
	{
		ModelAndView modelAndView = new ModelAndView("cadastro");	
		modelAndView.addObject("model", new ProdutoCadastroModel());		
		return modelAndView;
	}

	//método para receber o SUBMIT POST do formulário
	@RequestMapping(value = "/cadastrar-produto", method = RequestMethod.POST)
	public ModelAndView cadastrarTarefa(ProdutoCadastroModel model, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("tarefas-cadastro");		
		try
		{
			Produto produto = new Produto();	
			produto.setNome(model.getNome());
			produto.setDataValidade(DateHelper.formatToDate(model.getDataValidade()));
			produto.setQuantidade(Integer.parseInt(model.getQuantidade()));
			produto.setPreco(Double.parseDouble(model.getPreco()));
			produto.setDescricao(model.getDescricao());
			
			ProdutoRepository tarefaRepository = new ProdutoRepository();
			tarefaRepository.create(produto);
			
			modelAndView.addObject("mensagem", "Tarefa cadastrada com sucesso!");
		}
		catch(Exception e)
		{
			modelAndView.addObject("mensagem", "Ocorreu um erro: " + e.getMessage());
		}	
		modelAndView.addObject("model", new ProdutoCadastroModel());
		return modelAndView;
	}
}