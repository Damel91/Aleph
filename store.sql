create schema store;

use store;

create table cliente (
	
    username 		varchar(20) primary key,
    password 		varchar(20) not null,
	nome 			varchar(20) not null,
    cognome 		varchar(20) not null,
    nazione 		varchar(20) not null,
    città 	 		varchar(20) not null,
    indirizzo 		varchar(30) not null,
    telefono 		varchar (20),
    email          varchar(45) not null
);

create table libro (

	isbn				char(13) primary key,
    autore              varchar (100),
    titolo              varchar(100) not null,
    prezzo				double not null,
    n_copie			 	int not null,
    genere				char(10),
    immagine            varchar(100),
    data_inserimento    datetime,
    anno                int,
    casa_editrice		char(4)
						references casa_editrice(id_casa_editrice)
    
);

create table ordine(

    cliente				varchar(20) ,
    data_acquisto		datetime not null,
    prezzo_acquisto		double not null,
    stato               boolean default false not null,
	id_acquisto			int(6) AUTO_INCREMENT,
    
    primary key (id_acquisto),
    
    foreign key (cliente)
					references cliente(username)
                    on delete cascade
                    on update cascade
);

create table libro_ordine(

     ordine int(6),
     libro char(13),
     quantità_acquisto int not null,
     prezzo_acquisto double not null,
        
	foreign key (ordine)
					references ordine(id_acquisto)
                    on delete cascade
                    on update cascade,
    foreign key (libro)
					references libro(isbn)
                    on delete no action
                    on update cascade
     
);



create table casa_editrice(

    nome				varchar(30) not null,
    telefono			varchar(30),
    indirizzo 			varchar(30) not null,
    id_casa_editrice	int(4) primary key AUTO_INCREMENT
);
