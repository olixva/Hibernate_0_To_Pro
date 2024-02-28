package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "asalariado")
public class Asalariado extends Persona {

    //@NaturalId
    @Column(name = "nss", unique = true)
    private String nss;

    @Column(name = "sueldo")
    private double sueldo;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "iban")
    private String iban;

    @Column(name = "irpf")
    private String irpf;

    @Column(name = "importe_ss")
    private Integer importe_ss;

    @ManyToMany(mappedBy = "asalariados")
    private Set<Proyecto> proyectos = new HashSet<>();

}
