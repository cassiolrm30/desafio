create database desafio;
use desafio;

create table produto
(
	idproduto 		integer 		not null auto_increment,
	nome 			varchar(100) 	not null,
	descricao 		varchar(500) 	not null,
	preco 			double 			not null,
	quantidade 		integer 		not null,
	datavalidade	date 			not null,
    primary key(idproduto)
);

show tables;