package com.github.kgoedert.quarkus.panache.actor;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ActorRepository implements PanacheRepository<Actor>{

}