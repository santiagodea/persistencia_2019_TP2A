-- creo el schema
CREATE DATABASE `ciu-persistencia-facturacionH` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;

-- selecciono schema
use `ciu-persistencia-facturacionH`;



Hibernate: create table cliente (id integer not null auto_increment, apellido varchar(255) not null, codigo varchar(255) not null, nombre varchar(255) not null, primary key (id)) engine=InnoDB

Hibernate: create table cuenta (id integer not null auto_increment, numero varchar(255) not null, cliente_id integer, primary key (id)) engine=InnoDB
Hibernate: alter table cuenta add constraint cuenta_id_fk foreign key (cliente_id) references cliente (id)
Hibernate: insert into cliente (apellido, codigo, nombre) values (?, ?, ?)
Hibernate: insert into cuenta (cliente_id, numero) values (?, ?)
Hibernate: insert into factura (cliente_id, fecha, numero) values (?, ?, ?)



