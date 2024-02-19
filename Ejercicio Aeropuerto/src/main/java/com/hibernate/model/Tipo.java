package com.hibernate.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tipos")
public class Tipo {

    @Id
    private String modelo;

    private int capacidad;

    private float peso;

    @OneToMany(mappedBy = "tipo")
    private Set<Avion> aviones = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "pilota", joinColumns = @JoinColumn(name = "tipo_modelo"), inverseJoinColumns = @JoinColumn(name = "piloto_nss"))
    private Set<Piloto> pilotos = new HashSet<>();

    public Tipo(String modelo, int capacidad, int peso) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.peso = peso;
    }

    public Tipo() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Set<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(Set<Avion> aviones) {
        this.aviones = aviones;
    }

    public Set<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(Set<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    @Override
    public String toString() {
        return "Tipo{" + "modelo='" + modelo + '\'' + ", capacidad=" + capacidad + ", peso=" + peso + '}';
    }
}
