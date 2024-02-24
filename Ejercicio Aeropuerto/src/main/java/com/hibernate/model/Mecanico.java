package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mecanicos")
public class Mecanico extends Persona {

    @Column(name = "salario")
    private Double salario;

    @Column(name = "turno")
    private String turno;

    @ManyToMany(mappedBy = "mecanicos")
    private Set<Avion> aviones = new HashSet<>();

    public Mecanico() {
    }

    public Mecanico(String nss, String nombre, String direccion, Double salario, String turno) {
        super(nss, nombre, direccion);
        this.salario = salario;
        this.turno = turno;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Mecanico{" +
                "salario=" + salario +
                ", turno='" + turno + '\'' +
                '}';
    }
}