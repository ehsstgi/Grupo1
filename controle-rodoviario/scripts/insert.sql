delete from passagem;
delete from viagem;
delete from carro;
delete from linha;
delete from cidade;
delete from usuario;
delete from sequence_table;

insert into cidade (ID, ESTADO, NOME) values (1, 'SP', 'Campinas');
insert into cidade (ID, ESTADO, NOME) values (2, 'SP', 'Guarulhos');
insert into cidade (ID, ESTADO, NOME) values (3, 'SP', 'Mococa');
insert into cidade (ID, ESTADO, NOME) values (4, 'PR', 'Curitiba');
insert into cidade (ID, ESTADO, NOME) values (5, 'RS', 'Porto Alegre');
insert into cidade (ID, ESTADO, NOME) values (6, 'SC', 'Joinville');
insert into cidade (ID, ESTADO, NOME) values (7, 'SC', 'Blumenau');
insert into cidade (ID, ESTADO, NOME) values (8, 'RJ', 'Rio de Janeiro');
insert into cidade (ID, ESTADO, NOME) values (9, 'RN', 'Natal');
insert into cidade (ID, ESTADO, NOME) values (10, 'BA', 'Salvador');
insert into cidade (ID, ESTADO, NOME) values (11, 'SP', 'São Paulo');
insert into sequence_table (SEQ_NAME, SEQ_COUNT) values ('CIDADE_ID', 11);


insert into linha (ID, NOME, DESTINO_ID, ORIGEM_ID) values (1, 'Joinville-Campinas', 1, 6);
insert into linha (ID, NOME, DESTINO_ID, ORIGEM_ID) values (2, 'Porto Alegre-Guarulhos', 2, 5);
insert into linha (ID, NOME, DESTINO_ID, ORIGEM_ID) values (3, 'Rio de Janeiro-Natal', 9, 8);
insert into sequence_table (SEQ_NAME, SEQ_COUNT) values ('LINHA_ID', 3);

insert into carro (ID, ASSENTOS, DESCRICAO) values (1, 40, '0001 Onibus 40 lugares');
insert into carro (ID, ASSENTOS, DESCRICAO) values (2, 40, '0002 Onibus 40 lugares');
insert into carro (ID, ASSENTOS, DESCRICAO) values (3, 40, '0003 Onibus 40 lugares');
insert into carro (ID, ASSENTOS, DESCRICAO) values (4, 40, '0004 Onibus 40 lugares');
insert into sequence_table (SEQ_NAME, SEQ_COUNT) values ('CARRO_ID', 4);

insert into viagem(id, data, descricao, distancia, duracao, carro_id, linha_id, origem_id, destino_id) values (1, '2012-06-10-00.00.00', 'Joinville-Campinas, Direto', 600, 10, 1, 1, 6, 1);
insert into viagem(id, data, descricao, distancia, duracao, carro_id, linha_id, origem_id, destino_id) values (2, '2012-06-10-00.00.00', 'Joinville-Curitiba', 120, 2, 1, 1, 6, 4);
insert into viagem(id, data, descricao, distancia, duracao, carro_id, linha_id, origem_id, destino_id) values (3, '2012-06-10-00.00.00', 'Joinville-São Paulo', 500, 9, 1, 1, 6, 11);
insert into viagem(id, data, descricao, distancia, duracao, carro_id, linha_id, origem_id, destino_id) values (4, '2012-06-10-02.00.00', 'Curitiba-São Paulo', 380, 7, 1, 1, 4, 11);
insert into viagem(id, data, descricao, distancia, duracao, carro_id, linha_id, origem_id, destino_id) values (5, '2012-06-10-02.00.00', 'Curitiba-Campinas', 480, 8, 1, 1, 4, 1);
insert into viagem(id, data, descricao, distancia, duracao, carro_id, linha_id, origem_id, destino_id) values (6, '2012-06-10-09.00.00', 'São Paulo-Campinas', 100, 1, 1, 1, 11, 1);
insert into sequence_table (SEQ_NAME, SEQ_COUNT) values ('VIAGEM_ID', 6);

insert into usuario (ID, CPF, EMAIL, NOME, SENHA, PERFIL) values (1, '000.000.000-00', 'teste@teste.com', 'teste', 'teste', 'user');
insert into usuario (ID, CPF, EMAIL, NOME, SENHA, PERFIL) values (2, '000.000.000-00', 'admin@admin.com', 'admin', 'admin', 'admin');
insert into sequence_table (SEQ_NAME, SEQ_COUNT) values ('USUARIO_ID', 2);

insert into PASSAGEM (ID, NOMEPASSAGEIRO, USUARIO_ID, VIAGEM_ID, NUMEROASSENTO) values (1, 'João', 1, 1, 4);
insert into PASSAGEM (ID, NOMEPASSAGEIRO, USUARIO_ID, VIAGEM_ID, NUMEROASSENTO) values (2, 'Maria', 1, 3, 7);
insert into PASSAGEM (ID, NOMEPASSAGEIRO, USUARIO_ID, VIAGEM_ID, NUMEROASSENTO) values (3, 'Pedro', 1, 2, 3);
insert into PASSAGEM (ID, NOMEPASSAGEIRO, USUARIO_ID, VIAGEM_ID, NUMEROASSENTO) values (4, 'Carol', 1, 6, 14);
insert into sequence_table (SEQ_NAME, SEQ_COUNT) values ('PASSAGEM_ID', 4);