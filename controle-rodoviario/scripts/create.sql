create table cidade(
id identity,
descricao varchar(50),
estado varchar(2)
);

create table carro(
id identity,
descricao varchar(50),
numero_assentos number(3,0)
);

create table usuario(
id identity,
email varchar(30),
senha varchar(30),
nome varchar(50),
data_nascimento date,
cpf varchar(11)
);

create table linha(
id identity,
nome varchar(50),
id_cidade_origem number,
id_cidade_destino number
);

create table viagem(
id identity,
id_linha number,
id_cidade_origem number,
id_cidade_destino number,
id_carro number,
distancia number,
data_viagem timestamp,
descricao varchar(50),
duracao_viagem number
);

create table passagem(
id identity,
id_viagem number,
id_usuario number,
id_forma_pagamento number,
nome_passageiro varchar(50),
documento_passageiro varchar(11),
valor number(10,2)
);

create table assento(
id_viagem number,
id_passagem number,
numero_assento number(3,0)
letra_assento varchar(2)
);