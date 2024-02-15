package com.hibernate.model;

import jakarta.persistence.Entity;

@Entity
public class Mecanico extends Persona {

    private String salario;
    private float turno;

    public Mecanico(String nss, String nombre, String direccion, String salario, float turno) {
        super(nss, nombre, direccion);
        this.salario = salario;
        this.turno = turno;
    }

    public Mecanico() {
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public float getTurno() {
        return turno;
    }

    public void setTurno(float turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Mecanico{" +
                "salario='" + salario + '\'' +
                ", turno='" + turno + '\'' +
                '}';
    }
}
