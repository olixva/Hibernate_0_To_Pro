package com.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tipo {

    @Id
    private String modelo;

    private int capacidad;

    private float peso;

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

    @Override
    public String toString() {
        return "Tipo{" +
                "modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                ", peso=" + peso +
                '}';
    }
}
