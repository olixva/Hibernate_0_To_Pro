package com.iescierva.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tecnicos")
public class Tecnico extends Empleado{

    @Column(name = "nivel")
    private String nivel;

    @ManyToMany
    @JoinTable(
            name = "trabaja", // Tabla intermedia
            joinColumns = @JoinColumn(name = "num_matricula", referencedColumnName = "num_matricula"),
            inverseJoinColumns = @JoinColumn(name = "cod_proyecto", referencedColumnName = "cod_proyecto")
    )
    private Set<Proyecto> proyectos;

    public Tecnico() {
    }

    public Tecnico(String numMatricula, String nombre, String direccion, Departamento departamento, String nivel) {
        super(numMatricula, nombre, direccion, departamento);
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public String toString() {
        return "Tecnico{" + "nivel=" + nivel + '}';
    }
}
