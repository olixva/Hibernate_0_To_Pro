package com.ingeniero.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Pelicula extends Obra{

    private int duracion;

    public Pelicula() {
    }

    public Pelicula(String codObra, String nombre, LocalDate anyo, int duracion) {
        super(codObra, nombre, anyo);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "codObra=" + super.getCodObra() +
                ", nombre='" + super.getNombre() + '\'' +
                ", anyo=" + super.getAnyo() +
                ", duracion=" + duracion +
                '}';
    }
}
