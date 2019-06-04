-- creo el schema
CREATE DATABASE `ciu-persistencia-facturacionH` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;

-- selecciono schema
use `ciu-persistencia-facturacionH`;


alter table cuenta drop foreign key cuenta_id_fk;
 alter table detalle drop foreign key factura_detalle_id_fk;
 alter table detalle drop foreign key FKf6pm60f8wvayy41dtadrk4nce;
 alter table detalle drop foreign key FKc335dhjv2v7hg3s4qda4vhtan;
 alter table factura drop foreign key cliente_id_fk;
 alter table factura_detalle drop foreign key FKboyab7pqyi1hvhqx7l03wq65v;
 alter table factura_detalle drop foreign key FKs0a5n8i3vatd6kkqv7mxhmnix;
 alter table precio drop foreign key precio_id_fk;
 alter table producto_proveedor drop foreign key FKekrq26m4b66841u1jwr75hpd7;
 alter table producto_proveedor drop foreign key FKkhe5o8i7r539uvfhupljqr9jr;

 drop table if exists cliente;
 drop table if exists cuenta;
 drop table if exists detalle;
 drop table if exists factura;
 drop table if exists factura_detalle;
 drop table if exists precio;
 drop table if exists producto;
 drop table if exists producto_proveedor;
 drop table if exists proveedor;

 create table cliente (id integer not null auto_increment, apellido varchar(255) not null, codigo varchar(255) not null, nombre varchar(255) not null, primary key (id)) engine=InnoDB;
 create table cuenta (id integer not null auto_increment, numero varchar(255) not null, cliente_id integer, primary key (id)) engine=InnoDB;
 create table detalle (id integer not null auto_increment, cantidad integer, factura_id integer, precioDeVenta_id integer, precio_id integer, primary key (id)) engine=InnoDB;
 create table factura (id integer not null auto_increment, fecha date not null, numero integer not null, cliente_id integer, primary key (id)) engine=InnoDB;
 create table factura_detalle (Factura_id integer not null, detalles_id integer not null) engine=InnoDB;
 create table precio (id integer not null auto_increment, fecha date not null, monto double precision not null, producto_id integer, primary key (id)) engine=InnoDB;
 create table producto (id integer not null auto_increment, codigo varchar(255) not null, descripcion varchar(255) not null, primary key (id)) engine=InnoDB;
 create table producto_proveedor (productos_id integer not null, proveedores_id integer not null) engine=InnoDB;
 create table proveedor (id integer not null auto_increment, codigo varchar(255) not null, descripcion varchar(255) not null, primary key (id)) engine=InnoDB;
 alter table cliente add constraint UK_jhug2gvm17hj5sqykqqf3ks01 unique (codigo);
 alter table cuenta add constraint UK_hsp0g5b3ckv9kgikc6e85l1jb unique (numero);
 alter table factura add constraint UK_4bd3nq8ndl753rig6e8qh4s7y unique (numero);
 alter table factura_detalle add constraint UK_2h1pfau8sbw4h9bwfe9roicwm unique (detalles_id);
 alter table precio add constraint UK_nfyalpqnfh08kk3fsx64yatn1 unique (monto);
 alter table proveedor add constraint UK_fv9v7texgc45msb3vgmi4cc2w unique (codigo);
 alter table cuenta add constraint cuenta_id_fk foreign key (cliente_id) references cliente (id);
 alter table detalle add constraint factura_detalle_id_fk foreign key (factura_id) references factura (id);
 alter table detalle add constraint FKf6pm60f8wvayy41dtadrk4nce foreign key (precioDeVenta_id) references precio (id);
 alter table detalle add constraint FKc335dhjv2v7hg3s4qda4vhtan foreign key (precio_id) references producto (id);
 alter table factura add constraint cliente_id_fk foreign key (cliente_id) references cliente (id);
 alter table factura_detalle add constraint FKboyab7pqyi1hvhqx7l03wq65v foreign key (detalles_id) references detalle (id);
 alter table factura_detalle add constraint FKs0a5n8i3vatd6kkqv7mxhmnix foreign key (Factura_id) references factura (id);
 alter table precio add constraint precio_id_fk foreign key (producto_id) references producto (id);
 alter table producto_proveedor add constraint FKekrq26m4b66841u1jwr75hpd7 foreign key (proveedores_id) references proveedor (id);
 alter table producto_proveedor add constraint FKkhe5o8i7r539uvfhupljqr9jr foreign key (productos_id) references producto (id);

 insert into cliente (apellido, codigo, nombre) values (?, ?, ?);
 insert into cuenta (cliente_id, numero) values (?, ?);
 insert into cliente (apellido, codigo, nombre) values (?, ?, ?);
 insert into cuenta (cliente_id, numero) values (?, ?);
 insert into cliente (apellido, codigo, nombre) values (?, ?, ?);
 insert into cuenta (cliente_id, numero) values (?, ?);
 insert into producto (codigo, descripcion) values (?, ?);
 insert into proveedor (codigo, descripcion) values (?, ?);
 insert into precio (fecha, monto, producto_id) values (?, ?, ?);
 insert into producto (codigo, descripcion) values (?, ?);
 insert into proveedor (codigo, descripcion) values (?, ?);
 insert into precio (fecha, monto, producto_id) values (?, ?, ?);
 insert into producto (codigo, descripcion) values (?, ?);
 insert into proveedor (codigo, descripcion) values (?, ?);
 insert into precio (fecha, monto, producto_id) values (?, ?, ?);
 insert into factura (cliente_id, fecha, numero) values (?, ?, ?);
 insert into detalle (cantidad, factura_id, precioDeVenta_id, precio_id) values (?, ?, ?, ?);
 insert into detalle (cantidad, factura_id, precioDeVenta_id, precio_id) values (?, ?, ?, ?);
 insert into factura (cliente_id, fecha, numero) values (?, ?, ?);
 insert into detalle (cantidad, factura_id, precioDeVenta_id, precio_id) values (?, ?, ?, ?);
 insert into detalle (cantidad, factura_id, precioDeVenta_id, precio_id) values (?, ?, ?, ?);
 insert into detalle (cantidad, factura_id, precioDeVenta_id, precio_id) values (?, ?, ?, ?);
 insert into factura (cliente_id, fecha, numero) values (?, ?, ?);
 insert into detalle (cantidad, factura_id, precioDeVenta_id, precio_id) values (?, ?, ?, ?);
 insert into detalle (cantidad, factura_id, precioDeVenta_id, precio_id) values (?, ?, ?, ?);
 insert into producto_proveedor (productos_id, proveedores_id) values (?, ?);
 insert into producto_proveedor (productos_id, proveedores_id) values (?, ?);
 insert into producto_proveedor (productos_id, proveedores_id) values (?, ?);
 insert into factura_detalle (Factura_id, detalles_id) values (?, ?);
 insert into factura_detalle (Factura_id, detalles_id) values (?, ?);
 insert into factura_detalle (Factura_id, detalles_id) values (?, ?);
 insert into factura_detalle (Factura_id, detalles_id) values (?, ?);
 insert into factura_detalle (Factura_id, detalles_id) values (?, ?);
 insert into factura_detalle (Factura_id, detalles_id) values (?, ?);
 insert into factura_detalle (Factura_id, detalles_id) values (?, ?);
