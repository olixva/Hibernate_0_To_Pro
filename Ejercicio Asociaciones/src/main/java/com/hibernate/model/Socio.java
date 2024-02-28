package com.hibernate.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "socio")
public class Socio extends Persona {

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    @Column(name = "cuota_mensual")
    private Double cuotaMensual;

    // @Column(name = "cuota_anual", nullable = true)
    // private Double cuotaAnual;

    @ManyToMany(mappedBy = "socios")
    private Set<Proyecto> proyectos = new HashSet<>();



}
