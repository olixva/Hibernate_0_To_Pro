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

    @OneToMany(mappedBy = "hangar")
    private Set<Avion> aviones = new HashSet<>();


    private int capacidad;

    private String localizacion;

    public Hangar(String codHangar, int capacidad, String localizacion) {
        this.codHangar = codHangar;
        this.capacidad = capacidad;
        this.localizacion = localizacion;
    }

    public Hangar() {
    }

    public String getCodHangar() {
        return codHangar;
    }

    public void setCodHangar(String codHangar) {
        this.codHangar = codHangar;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
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
