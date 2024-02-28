package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.*;

@Entity
@Table(name = "asociacion")
public class Asociacion {

    @Id
    @Column(name = "codigo_asociacion")
    private String codigoAsociacion;

    @NaturalId
    @Column(name = "cif", unique = true)
    private String cif;

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "utilidad")
    private String utilidad;

    // @ElementCollection
    // @CollectionTable(name = "persona_telefonos", joinColumns = @JoinColumn(name = "num_afi"))
    // private List<String> direccion = new ArrayList<>();

    @OneToMany(mappedBy = "codigoAsociacion")
    private Set<Proyecto> proyectos = new HashSet<>();

    @OneToMany(mappedBy = "asociacion")
    private Set<Persona> personas = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "persige",
            joinColumns = @JoinColumn(name = "codigo_asociacion"),
            inverseJoinColumns = @JoinColumn(name = "codigo_objetivo")
    )
    private Set<Objetivo> objetivos = new HashSet<>();





}
