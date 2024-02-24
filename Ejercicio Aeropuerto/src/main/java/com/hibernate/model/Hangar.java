package com.hibernate.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hangares")
public class Hangar {

    @Id
    @Column(name = "cod_hangar")
    private String codHangar;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "localizacion")
    private String localizacion;

    @OneToMany(mappedBy = "hangar")
    private Set<Avion> aviones = new HashSet<>();

    public Hangar() {
    }

    public Hangar(String codHangar, Integer capacidad, String localizacion) {
        this.codHangar = codHangar;
        this.capacidad = capacidad;
        this.localizacion = localizacion;
    }

    public String getCodHangar() {
        return codHangar;
    }

    public void setCodHangar(String codHangar) {
        this.codHangar = codHangar;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Set<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(Set<Avion> aviones) {
        this.aviones = aviones;
    }

    @Override
    public String toString() {
        return "Hangar{" +
                "codHangar='" + codHangar + '\'' +
                ", capacidad=" + capacidad +
                ", localizacion='" + localizacion + '\'' +
                '}';
    }
}