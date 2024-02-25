package com.ingeniero.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Cd extends Obra{

    @Column(name = "n_canciones")
    private int nCanciones;

    public Cd() {
    }


    public Cd(String codObra, String nombre, LocalDate anyo, int nCanciones) {
        super(codObra, nombre, anyo);
        this.nCanciones = nCanciones;
    }

    public int getnCanciones() {
        return nCanciones;
    }

    public void setnCanciones(int nCanciones) {
        this.nCanciones = nCanciones;
    }

    @Override
    public String toString() {
        return "Cd{" +
                "codObra=" + super.getCodObra() +
                ", nombre='" + super.getNombre() + '\'' +
                ", anyo=" + super.getAnyo() +
                ", nCanciones=" + nCanciones +
                '}';
    }

}
