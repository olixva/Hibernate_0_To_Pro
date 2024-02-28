package com.hibernate.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnicos")
public class Tecnico extends Usuario {

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    @Column(name = "especialidad", nullable = true)
    private String especialidad;

    @ManyToMany(mappedBy = "tecnicos")
    private Set<Tarea> tareas = new HashSet<>();

    public Tecnico() {
    }

    public Tecnico(String codUsuario, String login, String email, String email2, String nombre, String apellidos, LocalDate fechaAlta, String especialidad) {
        super(codUsuario, login, email, email2, nombre, apellidos);
        this.fechaAlta = fechaAlta;
        this.especialidad = especialidad;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Set<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "fechaAlta=" + fechaAlta +
                ", especialidad='" + especialidad + '\'' +
                ", tareas=" + tareas +
                '}';
    }
}
