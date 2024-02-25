package com.ingeniero.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Libro extends Obra{

    @Column(name = "n_pags")
    private int nPags;

    public Libro() {
    }

    public Libro(String codObra, String nombre, LocalDate anyo, int nPags) {
        super(codObra, nombre, anyo);
        this.nPags = nPags;
    }

    public int getnPags() {
        return nPags;
    }

    public void setnPags(int nPags) {
        this.nPags = nPags;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codObra=" + super.getCodObra() +
                ", nombre='" + super.getNombre() + '\'' +
                ", anyo=" + super.getAnyo() +
                ", nPags=" + nPags +
                '}';
    }
}
