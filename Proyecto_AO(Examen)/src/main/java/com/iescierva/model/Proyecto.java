package com.iescierva.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @Column(name = "cod_proyecto")
    private String codProyecto;

    @Column(name = "nombre_proyecto")
    private String nombreProyecto;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private LocalDate fechaFin;

    @Column(name = "cliente")
    private String cliente;

    @ManyToMany(mappedBy = "proyectos")
    private Set<Tecnico> tecnicos = new HashSet<>();

    public Proyecto() {
    }

    public Proyecto(String codProyecto, String nombreProyecto, LocalDate fechaInicio, LocalDate fechaFin, String cliente) {
        this.codProyecto = codProyecto;
        this.nombreProyecto = nombreProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
    }

    public String getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(String codProyecto) {
        this.codProyecto = codProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Set<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(Set<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "codProyecto=" + codProyecto + ", nombreProyecto=" + nombreProyecto + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", cliente=" + cliente + ", tecnicos=" + tecnicos + '}';
    }
}
