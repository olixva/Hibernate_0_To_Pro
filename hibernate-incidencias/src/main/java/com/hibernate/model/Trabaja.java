package com.hibernate.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "trabaja")
public class Trabaja {

    @Id
    @Column(name = "cod_tecnico")
    private String codTecnico;

    @Id
    @Column(name = "cod_incidencia")
    private String codIncidencia;

    @ManyToOne
    @JoinColumn(name = "cod_rol")
    private Rol codRol;

    @Id
    @Column(name = "num_orden")
    private Integer numOrden;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "trabajo_realizado")
    private String trabajoRealizado;

    public Trabaja() {
    }

    public Trabaja(Tecnico tecnico, Incidencia incidencia, Integer numOrden, Rol codRol, 
            LocalDate fecha, String trabajoRealizado) {
        this.codTecnico = tecnico.getCodUsuario();
        this.codIncidencia = incidencia.getCodIncidencia();
        this.numOrden = numOrden;
        this.codRol = codRol;
        this.fecha = fecha;
        this.trabajoRealizado = trabajoRealizado;
    }

    public String getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(String codTecnico) {
        this.codTecnico = codTecnico;
    }

    public String getCodIncidencia() {
        return codIncidencia;
    }

    public void setCodIncidencia(String codIncidencia) {
        this.codIncidencia = codIncidencia;
    }

    public Rol getCodRol() {
        return codRol;
    }

    public void setCodRol(Rol codRol) {
        this.codRol = codRol;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTrabajoRealizado() {
        return trabajoRealizado;
    }

    public void setTrabajoRealizado(String trabajoRealizado) {
        this.trabajoRealizado = trabajoRealizado;
    }

    @Override
    public String toString() {
        return "Trabaja [codRol=" + codRol + ", codTarea=" + codIncidencia + ", codTecnico=" + codTecnico + ", fecha=" + fecha
                + ", trabajoRealizado=" + trabajoRealizado + "]";
    }
    
}
