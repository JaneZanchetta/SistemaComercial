CREATE DATABASE "SisCom"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

CREATE TABLE cliente(
id SERIAL PRIMARY KEY NOT NULL,  
nome VARCHAR(50) NOT NULL,
telefone varchar (50),
endereco varchar (50),
cidade varchar (50),
uf varchar (2),
email varchar (50),
genero varchar (30)
);

create table Usuario (

id SERIAL PRIMARY KEY NOT NULL,
idCliente int not null, 
senha varchar(10));


ALTER TABLE Usuario
ADD CONSTRAINT fk_idCliente FOREIGN KEY (idcliente) REFERENCES cliente (id) MATCH FULL;



create table Produto (
id serial primary key,
descricao varchar(50) not null,
codBar int,
categoria varchar (30),
unidade varchar (30),
custo numeric(12,2),
margemLucro numeric(5,2)
);

