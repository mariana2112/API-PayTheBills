CREATE TABLE Contareceber (
    idcompra int not null AUTO_INCREMENT PRIMARY KEY,
    datacompra Date not null,
    valor decimal(12,2),
    idcliente int not null
);


ALTER TABLE Contareceber add CONSTRAINT FK_ContasReceber_Cliente foreign key(idcliente) references Cliente(idcliente);

insert into cliente (nome) values ("Victor");
insert into cliente (nome) values ("Mariana Rove");
insert into cliente (nome) values ("Fernando");
insert into cliente (nome) values ("Vinicius");
insert into cliente (nome) values ("Vitão");
insert into cliente (nome) values ("Matheus");

insert into Contareceber (datacompra, valor, idcliente) values ('2020-12-25', 5000, 2);
insert into Contareceber (datacompra, valor, idcliente) values ('2020-10-1', 1000, 3);
insert into Contareceber(datacompra, valor, idcliente) values ('2020-5-12', 3400, 1);
insert into Contareceber (datacompra, valor, idcliente) values ('2020-2-24', 2951, 6);
insert into Contareceber (datacompra, valor, idcliente) values ('2020-1-20', 1082, 5);