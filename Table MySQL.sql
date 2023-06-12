create database prova;

use prova;

create table inscricoes(
  id_insc INT PRIMARY KEY,
  nome VARCHAR(100),
  cpf VARCHAR(15),
  telefone VARCHAR(20),
  email VARCHAR(50),
  endereco VARCHAR(100),
  cidade VARCHAR(50),
  estado VARCHAR(2),
  cep VARCHAR(9)
  ); 
  
select * from inscricoes;
