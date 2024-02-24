package com.hibernate.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnico")
public class Tecnico extends Usuario {

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    @Column(name = "especialidad", nullable = true)
    private String especialidad;

    public Tecnico() {
    }

    public Tecnico(String codUsuario, String login, String nombre, 
            String especialidad, LocalDate fechaAlta) {
        super(codUsuario, login, nombre);
        this.especialidad = especialidad;
        this.fechaAlta = fechaAlta;
    }

    public Tecnico(String codUsuario, String login, String nombre, 
            String email, String especialidad, LocalDate fechaAlta) {
        super(codUsuario, login, nombre, email);
        this.especialidad = especialidad;
        this.fechaAlta = fechaAlta;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Tecnico [especialidad=" + especialidad + ", fechaAlta=" + fechaAlta + "]";
    }

}
