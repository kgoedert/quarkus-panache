package com.github.kgoedert.quarkus.panache.movie;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {

}