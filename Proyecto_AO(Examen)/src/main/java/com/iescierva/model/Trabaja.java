package com.iescierva.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "trabaja")
public class Trabaja {

    @Id
    @Column(name = "num_matricula", insertable = false, updatable = false)
    private String numMatricula;

    @Id
    @Column(name = "cod_proyecto", insertable = false, updatable = false)
    private String codProyecto;

    @Column(name = "fecha_asignacion")
    private LocalDate fechaAsignacion;

    @Column(name = "fecha_cese")
    private LocalDate fechaCese;

    public Trabaja() {
    }

    public Trabaja(Tecnico tecnico, Proyecto proyecto, LocalDate fechaAsignacion, LocalDate fechaCese) {
        this.numMatricula = tecnico.getNumMatricula();
        this.codProyecto = proyecto.getCodProyecto();
        this.fechaAsignacion = fechaAsignacion;
        this.fechaCese = fechaCese;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(String codProyecto) {
        this.codProyecto = codProyecto;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public LocalDate getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(LocalDate fechaCese) {
        this.fechaCese = fechaCese;
    }

    @Override
    public String toString() {
        return "Trabaja{" +
                "numMatricula='" + numMatricula + '\'' +
                ", codProyecto='" + codProyecto + '\'' +
                ", fechaAsignacion=" + fechaAsignacion +
                ", fechaCese=" + fechaCese +
                '}';
    }
}
