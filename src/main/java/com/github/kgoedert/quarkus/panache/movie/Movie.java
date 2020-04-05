package com.github.kgoedert.quarkus.panache.movie;

    import javax.persistence.Entity;

    import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Movie extends PanacheEntity {
    public String title;
    public String director;
    public String genre;
}