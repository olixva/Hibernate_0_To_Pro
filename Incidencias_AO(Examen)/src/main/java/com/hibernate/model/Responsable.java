package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "responsables")
public class Responsable extends Usuario {

    @Column(name = "cualificacion")
    private String cualificacion;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "responsable")
    private Set<Incidencia> tareas = new HashSet<Incidencia>();

    public Responsable() {
    }

    public Responsable(String codUsuario, String login, String email, String email2, String nombre, String apellidos, String cualificacion, String descripcion) {
        super(codUsuario, login, email, email2, nombre, apellidos);
        this.cualificacion = cualificacion;
        this.descripcion = descripcion;
    }

    public String getCualificacion() {
        return cualificacion;
    }

    public void setCualificacion(String cualificacion) {
        this.cualificacion = cualificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Incidencia> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Incidencia> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return "Responsable{" +
                "cualificacion='" + cualificacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tareas=" + tareas +
                '}';
    }
}
