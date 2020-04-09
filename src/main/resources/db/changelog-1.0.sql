--liquibase formatted sql

--changeset movie:1
create table movie (
    id  integer primary key,
    title varchar(255) not null,
    director varchar(255) not null,
    genre varchar(50) not null
);
create sequence movie_id_seq increment 1 START 1 MINVALUE 1;

create table address(
    id integer primary key,
    city varchar(255) not null,
    state varchar(255) not null,
    country varchar(255) not null
);
create sequence address_id_seq;


create table actor(
    id integer primary key,
    name varchar(255) not null,
    age int,
    address_id integer references address(id)
);
create sequence actor_id_seq increment 1 start 1 MINVALUE 1;


create table movie_actor(
    id integer primary key,
    movie_id integer not null references movie(id),
    actor_id integer not null references actor(id)
);
create sequence movie_actor_id_seq;



create table budget(
    id integer primary key,
    movie_id integer not null references movie(id),
    description varchar(255),
    begin_date date,
    end_date date,
    budget numeric not null
);
create sequence budget_id_seq;

