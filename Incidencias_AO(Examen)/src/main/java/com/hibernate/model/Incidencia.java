package com.hibernate.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "incidencias")
public class Incidencia {

    @Id
    @Column(name = "cod_incidencia")
    private String codIncidencia;

    @Column(name = "fecha_apertura")
    private LocalDate fechaApertura;

    @Column(name = "fecha_cierre", nullable = true)
    private LocalDate fechaCierre;

    @Column(name = "solucion", nullable = true)
    private String solucion;

    //Usuario que pone la incidencia
    @ManyToOne
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;

    // Responsable al que se le asigna la incidencia
    @ManyToOne
    @JoinColumn(name = "cod_usuario_responsable")
    private Responsable responsable;

    // Localización de la incidencia
    @ManyToOne
    @JoinColumn(name = "cod_localizacion")
    private Localizacion localizacion;

    // Tareas que se han creado para la incidencia
    @OneToMany(mappedBy = "codIncidencia")
    private Set<Tarea> tareas = new HashSet<Tarea>();

    public Incidencia() {
    }

    public Incidencia(String codIncidencia, LocalDate fechaApertura, LocalDate fechaCierre, String solucion, Usuario usuario, Responsable responsable, Localizacion localizacion) {
        this.codIncidencia = codIncidencia;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.solucion = solucion;
        this.usuario = usuario;
        this.responsable = responsable;
        this.localizacion = localizacion;
    }

    public String getCodIncidencia() {
        return codIncidencia;
    }

    public void setCodIncidencia(String codIncidencia) {
        this.codIncidencia = codIncidencia;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public Set<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "codIncidencia='" + codIncidencia + '\'' +
                ", fechaApertura=" + fechaApertura +
                ", fechaCierre=" + fechaCierre +
                ", solucion='" + solucion + '\'' +
                ", usuario=" + usuario +
                ", responsable=" + responsable +
                ", localizacion=" + localizacion +
                ", tareas=" + tareas +
                '}';
    }
}
