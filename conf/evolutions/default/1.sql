# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table admin (
  id_cliente                bigint auto_increment not null,
  nombre                    varchar(255),
  apellido                  varchar(255),
  direccion                 varchar(255),
  estado                    varchar(255),
  telefono                  varchar(255),
  email                     varchar(255),
  usuario                   varchar(255),
  contra                    varchar(255),
  role_id                   bigint,
  constraint pk_admin primary key (id_cliente))
;

create table cliente (
  id_cliente                bigint auto_increment not null,
  nombre                    varchar(255),
  apellido                  varchar(255),
  direccion                 varchar(255),
  estado                    varchar(255),
  telefono                  varchar(255),
  email                     varchar(255),
  usuario_id_usuario        bigint,
  constraint pk_cliente primary key (id_cliente))
;

create table role (
  id                        bigint auto_increment not null,
  rol                       varchar(255),
  constraint pk_role primary key (id))
;

create table usuario (
  id_usuario                bigint auto_increment not null,
  usuario                   varchar(255),
  password                  varchar(255),
  constraint pk_usuario primary key (id_usuario))
;

create table zapato (
  id_zapato                 bigint auto_increment not null,
  modelo                    varchar(255),
  talla                     varchar(255),
  constraint pk_zapato primary key (id_zapato))
;

alter table admin add constraint fk_admin_role_1 foreign key (role_id) references role (id) on delete restrict on update restrict;
create index ix_admin_role_1 on admin (role_id);
alter table cliente add constraint fk_cliente_usuario_2 foreign key (usuario_id_usuario) references usuario (id_usuario) on delete restrict on update restrict;
create index ix_cliente_usuario_2 on cliente (usuario_id_usuario);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table admin;

drop table cliente;

drop table role;

drop table usuario;

drop table zapato;

SET FOREIGN_KEY_CHECKS=1;

