package com.hibernate.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @Column(name = "codigo_proyecto")
    private String codigoProyecto;

    @ManyToOne
    @JoinColumn(name = "codigo_asociacion")
    private Asociacion codigoAsociacion;

    @Column(name = "pais")
    private String pais;

    @Column(name = "beneficiarios")
    private Integer beneficiarios;

    @Column(name = "zona")
    private String zona;

    @Column(name = "fecha_cierre")
    private LocalDate fechaCierre;

    @ManyToMany
    @JoinTable(name = "persigue",
            joinColumns = @JoinColumn(name = "codigo_proyecto"),
            inverseJoinColumns = @JoinColumn(name = "codigo_objetivo")
    )
    private Set<Objetivo> objetivos = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "apoya",
            joinColumns = @JoinColumn(name = "codigo_proyecto"),
            inverseJoinColumns = @JoinColumn(name = "num_afi")
    )
    private Set<Socio> socios = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "participa",
            joinColumns = @JoinColumn(name = "codigo_proyecto"),
            inverseJoinColumns = @JoinColumn(name = "num_afi")
    )
    private Set<Asalariado> asalariados = new HashSet<>();

}
