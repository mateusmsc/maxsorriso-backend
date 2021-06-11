use maxsorrisodb;

create table paciente(
	id int auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    telefone varchar(255) not null,
    data_nascimento date not null,
    primary key(id)
);

create table doutor(
	id int auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    telefone varchar(255) not null,
    data_nascimento date not null,
    uf varchar(2) not null,
	crm varchar(100) not null,
    primary key(id)
);

create table status_caso(
	id int auto_increment,
    descricao varchar(255) not null,
    primary key(id)
);

create table tomografia (
	id int auto_increment,
    id_paciente int not null,
    cod_projeto varchar(255) not null,
    espessura_tc int not null,
    dicom blob,
    primary key(id),
    foreign key(id_paciente) references paciente(id)
);

create table casos (
	id int auto_increment,
    id_paciente int not null,
    id_doutor int not null,
    id_status int not null,
    id_tomografia int not null,
    data_cirurgia date not null,
    primary key(id),
    foreign key(id_paciente) references paciente(id),
    foreign key(id_doutor) references doutor(id),
	foreign key(id_status) references status_caso(id),
    foreign key(id_tomografia) references tomografia(id)
);

select * from status_caso;
select * from paciente;
select * from tomografia;
select * from casos;
select * from doutor;


/*
*       Criação de uma view completa para o casos como solicitado pelo frontend
*/

CREATE OR REPLACE VIEW casos_format AS
SELECT
	c.id id,
	d.nome nome_doutor,
	d.crm,
    CASE
       WHEN LENGTH(p.nome)-LENGTH(REPLACE(p.nome,' ',''))>=4 THEN
		CONCAT( LEFT(SUBSTRING_INDEX(p.nome, ' ', -5), 1),LEFT(SUBSTRING_INDEX(p.nome, ' ', -4), 1), LEFT(SUBSTRING_INDEX(p.nome, ' ', -3), 1),  LEFT(SUBSTRING_INDEX(p.nome, ' ', -2), 1), LEFT(SUBSTRING_INDEX(p.nome, ' ', -1), 1))
	   WHEN LENGTH(p.nome)-LENGTH(REPLACE(p.nome,' ',''))>=3 THEN
		CONCAT( LEFT(SUBSTRING_INDEX(p.nome, ' ', -4), 1), LEFT(SUBSTRING_INDEX(p.nome, ' ', -3), 1),  LEFT(SUBSTRING_INDEX(p.nome, ' ', -2), 1), LEFT(SUBSTRING_INDEX(p.nome, ' ', -1), 1))
	   WHEN LENGTH(p.nome)-LENGTH(REPLACE(p.nome,' ',''))>=2 THEN
		CONCAT( LEFT(SUBSTRING_INDEX(p.nome, ' ', -3), 1),  LEFT(SUBSTRING_INDEX(p.nome, ' ', -2), 1), LEFT(SUBSTRING_INDEX(p.nome, ' ', -1), 1))
	   WHEN LENGTH(p.nome)-LENGTH(REPLACE(p.nome,' ',''))>=1 THEN
		CONCAT(LEFT(SUBSTRING_INDEX(p.nome, ' ', -2), 1), LEFT(SUBSTRING_INDEX(p.nome, ' ', -1), 1))
   END Iniciais,
   c.data_cirurgia,
   c.id cod_caso,
   sc.descricao status_caso
FROM casos c
JOIN paciente p ON p.id = c.id_paciente
JOIN doutor d ON d.id = c.id_doutor
JOIN status_caso sc ON sc.id = c.id_status
JOIN tomografia t ON t.id = c.id_tomografia;