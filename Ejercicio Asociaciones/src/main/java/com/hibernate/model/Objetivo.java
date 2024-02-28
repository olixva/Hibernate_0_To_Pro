package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "objetivo")
public class Objetivo {

    @Id
    @Column(name = "codigo_objetivo")
    private String codigoObjetivo;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany(mappedBy = "objetivos")
    private Set<Asociacion> asociaciones = new HashSet<>();

}
