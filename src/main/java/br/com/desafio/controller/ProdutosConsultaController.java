package br.com.desafio.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.desafio.entities.Produto;
import br.com.desafio.helpers.DateHelper;
import br.com.desafio.models.ProdutoConsultaModel;
import br.com.desafio.repositories.ProdutoRepository;

@Controller
public class ProdutosConsultaController
{
	@RequestMapping(value = "/produtos-consulta")
	public ModelAndView consulta()
	{	
		ModelAndView modelAndView = new ModelAndView("consulta");
		modelAndView.addObject("model", new ProdutoConsultaModel());
		return modelAndView;
	}

	@RequestMapping(value = "/consultar-produtos", method = RequestMethod.GET)
	public ModelAndView consultarTarefas(ProdutoConsultaModel model, HttpServletRequest request)
	{	
		ModelAndView modelAndView = new ModelAndView("produtos-consulta");
		try
		{
			//capturar as datas informadas no formulário
			String nome = model.getNome();

			//acessando o repositório e consultar as tarefas
			ProdutoRepository repository = new ProdutoRepository();
			List<Produto> lista = repository.find(nome);
			
			// enviando a lista de registros para a página:
			modelAndView.addObject("produtos", lista);
			
			//gerando uma mensagem
			if (lista.size() > 0)
				modelAndView.addObject("mensagem", lista.size() + " registro(s) encontrada(s) para o período especificado.");
			else
				modelAndView.addObject("mensagem", "Nenhum registro encontrado para o período especificado.");
		}
		catch (Exception e)
		{
			//gerando uma mensagem de erro
			modelAndView.addObject("mensagem", "Ocorreu um erro: " + e.getMessage());
		}
		
		modelAndView.addObject("model", model);		
		return modelAndView;
	}
}