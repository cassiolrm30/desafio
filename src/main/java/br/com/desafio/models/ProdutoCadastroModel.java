package br.com.desafio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProdutoCadastroModel
{
	private String nome;
	private String dataValidade;
	private String quantidade;
	private String descricao;
	private String preco;	
}
