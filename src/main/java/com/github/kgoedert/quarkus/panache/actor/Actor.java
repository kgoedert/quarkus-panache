package com.github.kgoedert.quarkus.panache.actor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.github.kgoedert.quarkus.panache.actor.address.Address;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "actor")
@Access(AccessType.FIELD)
public class Actor extends PanacheEntityBase{
    @Id
    @GeneratedValue(generator = "actorSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
      name = "actorSeq", 
      sequenceName = "actor_id_seq", 
      allocationSize = 1
    )
    private Long id;

    @NotBlank
    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

	public void update(Actor actor) {
        this.age = actor.getAge();
        this.name = actor.getName();
	}
}