package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "responsable")
public class Responsable extends Usuario {

    @Column(name = "cualificacion")
    private Double cualificacion;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "responsable")
    private Set<Incidencia> tareas = new HashSet<Incidencia>();

    public Responsable() {
    }

    public Responsable(String codUsuario, String login, String nombre) {
        super(codUsuario, login, nombre);
    }

    public Responsable(String codUsuario, String login, String nombre, Double cualificacion, String descripcion) {
        super(codUsuario, login, nombre);
        this.cualificacion = cualificacion;
        this.descripcion = descripcion;
    }

    public Responsable(String codUsuario, String login, String nombre, String email, Double cualificacion, String descripcion) {
        super(codUsuario, login, nombre, email);
        this.cualificacion = cualificacion;
        this.descripcion = descripcion;
    }

    public Double getCualificacion() {
        return cualificacion;
    }

    public void setCualificacion(Double cualificacion) {
        this.cualificacion = cualificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Responsable [cualificacion=" + cualificacion + ", descripcion=" + descripcion + "]";
    }

    public Set<Incidencia> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Incidencia> tareas) {
        this.tareas = tareas;
    }

}
