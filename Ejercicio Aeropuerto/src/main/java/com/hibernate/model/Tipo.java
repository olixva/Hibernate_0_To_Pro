package com.hibernate.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tipos")
public class Tipo {

    @Id
    @Column(name = "modelo")
    private String modelo;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "peso")
    private Double peso;

    @OneToMany(mappedBy = "tipo")
    private Set<Avion> aviones;

    @ManyToMany(mappedBy = "tipos")
    private Set<Piloto> pilotos = new HashSet<>();

    public Tipo() {
    }

    public Tipo(String modelo, Integer capacidad, Double peso) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.peso = peso;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                ", peso=" + peso +
                '}';
    }
}