package com.github.kgoedert.quarkus.panache.actor.address;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "address")
@Access(AccessType.FIELD)
public class Address extends PanacheEntityBase{
    @Id
    @GeneratedValue(generator = "addressSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "addressSeq", sequenceName = "address_id_seq", allocationSize = 1)
    private Long id;

    @Column(name="country")
    private String country;

    @Column(name="state")
    private String state;

    @Column(name="city")
    private String city;
}