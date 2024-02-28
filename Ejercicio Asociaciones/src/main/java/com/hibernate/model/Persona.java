package com.hibernate.model;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    // Creamos los campos
    @Id
    @Column(name = "num_afi") 
    private String numAfi;

    @NaturalId
    @Column(name = "dni", unique = true)
    private String dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    // @ElementCollection
    // @CollectionTable(name = "persona_telefonos", joinColumns = @JoinColumn(name = "num_afi"))
    // private List<String> direccion = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "codigo_asociacion")
    private Asociacion asociacion;


}
