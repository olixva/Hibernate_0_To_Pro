package com.hibernate.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "incidencia")
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

    @ManyToOne
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "codIncidencia")
    private Set<Tarea> tareas = new HashSet<Tarea>();

    @ManyToOne
    @JoinColumn(name = "cod_usuario_responsable")
    private Responsable responsable;

    public Incidencia() {
    }

    public Incidencia(String codIncidencia, LocalDate fechaApertura) {
        this.codIncidencia = codIncidencia;
        this.fechaApertura = fechaApertura;
    }

    public Incidencia(String codIncidencia, LocalDate fechaApertura, LocalDate fechaCierre, String solucion) {
        this.codIncidencia = codIncidencia;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.solucion = solucion;
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

    public Set<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Incidencia [codIncidencia=" + codIncidencia + ", fechaApertura=" + fechaApertura + ", fechaCierre="
                + fechaCierre + ", solucion=" + solucion + "]";
    }

}
