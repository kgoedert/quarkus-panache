package com.github.kgoedert.quarkus.panache.movie;

import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.github.kgoedert.quarkus.panache.actor.Actor;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "movie")
@Access(AccessType.FIELD)
public class Movie extends PanacheEntityBase {
  @Id
  @GeneratedValue(generator = "movieSeq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "movieSeq", sequenceName = "movie_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "title")
  @NotBlank
  private String title;

  @Column(name = "director")
  @NotBlank
  private String director;

  @Column(name = "genre")
  @NotBlank
  private String genre;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "movie_actor", 
    joinColumns = @JoinColumn(name = "movie_id"), 
    inverseJoinColumns = @JoinColumn(name = "actor_id"))
  private Set<Actor> actors;
  
  public String getDirector() {
    return director;
  }

  public String getGenre() {
    return genre;
  }

  public String getTitle() {
    return title;
  }

  public Long getId() {
    return id;
  }

  public void update(Movie updated) {
    this.director = updated.getDirector();
    this.genre = updated.getGenre();
    this.title = updated.getTitle();
  }

}