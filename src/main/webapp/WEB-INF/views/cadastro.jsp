<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produtos</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
	<!-- estilo para os campos e mensagens de erro de validação -->
	<style>
		label.error { color: #d9534f; }
		input.error, select.error, textarea.error { border: 1px solid #d9534f; }
	</style>
</head>
<body>
	<!-- Menu do sistema -->
	<jsp:include page="/WEB-INF/views/components/menu.jsp"/>	
	<!-- notificações -->
	<jsp:include page="/WEB-INF/views/components/notifications.jsp"/>

	<div class="container mt-4">
		<div class="row mb-3">
			<div class="col-md-12">
				<h4><strong>AgendaWeb</strong> Cadastro de Produtos</h4>
				Preencha o formulário para incluir um produto:
			</div>
		</div>
		
		<form id="formCadastro" action="cadastrar-tarefa" method="post" class="mb-3">
			<div class="row mb-3">
				<div class="col-md-6">
					<label>Nome:</label>
					<form:input path="model.nome" id="nome" name="nome" type="text" class="form-control" placeholder="Digite o nome aqui." maxlength="100" />
				</div>
				<div class="col-md-2">
					<label>Data de Validade:</label>
					<form:input path="model.dataValidade" id="dataValidade" name="dataValidade" type="date" class="form-control"/>
				</div>
				<div class="col-md-2">
					<label>Quantidade:</label>
					<form:input path="model.quantidade" id="quantidade" name="quantidade" type="number" class="form-control"/>
				</div>
				<div class="col-md-2">
					<label>Preço:</label>
					<form:input path="model.preco" id="preco" name="preco" type="number" class="form-control"/>
				</div>
			</div>
			<div class="mb-3">
				<label>Descrição:</label>
				<form:textarea path="model.descricao" id="descricao" name="descricao" class="form-control" rows="4" placeholder="Digite a descrição aqui."></form:textarea>
			</div>
			<div class="mb-3">
				<input type="submit" value="Realizar Cadastro" class="btn btn-success"/>
				<a href="/desafio/consulta" class="btn btn-secondary">Voltar para a consulta</a>
			</div>
		</form>
	</div>

	<!-- JS do bootstrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
	<!-- JS do jquery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<!-- JS do jquery validation (posicionados após a referência do JQuery JS) -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>
	<script>
	$(document).ready(function()
	{	
		$("#formCadastro").validate
		({
			// Regras de validação dos campos
			rules:
			{									
				'nome' : { required : true },
				'dataValidade' : { required : true },
				'quantidade' : { required : true },
				'preco' : {	required : true	},
				'descricao' : {	required : true	}
			},

			// Mensagens de validação dos campos
			messages:
			{
				nome : { required : 'Por favor, informe o nome.' },				
				dataValidade : { required: 'Por favor, selecione a data de validade.' },
				quantidade : { required: 'Por favor, selecione a hora da tarefa.' },
				preco : { required: 'Por favor, selecione a prioridade da tarefa.' },
				descricao : { required: 'Por favor, preencha a descrição da tarefa.' }
			}
		});
	})
	</script>
</body>
</html>