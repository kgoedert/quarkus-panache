--liquibase formatted sql

--changeset movie:1
create table movie (
    id serial primary key,
    title varchar(255) not null,
    director varchar(255) not null,
    genre varchar(50) not null
);

create table actor(
    id serial primary key,
    name varchar(255) not null,
    age int,
    address_id integer not null references address(id)
);

create table movie_actor(
    id serial primary key,
    movie_id integer not null references movie(id),
    actor_id integer not null references actor(id)
);

create table address(
    id serial primary key,
    city varchar(255) not null,
    state varchar(255) not null,
    country varchar(255) not null
);

create table budget(
    id serial primary key,
    movie_id integer not null references movie(id),
    description varchar(255),
    begin_date date,
    end_date date,
    budget numeric not null
);
