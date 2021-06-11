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

