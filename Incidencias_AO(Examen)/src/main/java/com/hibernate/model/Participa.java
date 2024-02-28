package com.hibernate.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "participa")
public class Participa {

    // Tecnico
    @Id
    @Column(name = "cod_tecnico", insertable = false, updatable = false)
    private String codTecnico;

    // Tarea (Heredada de Incidencia)
    @Id
    @Column(name = "cod_incidencia", insertable = false, updatable = false)
    private String codIncidencia;

    // Tarea
    @Id
    @Column(name = "num_orden", insertable = false, updatable = false)
    private String numOrden;


    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "rol")
    private String rol;

    public Participa() {
    }

    public Participa(Tecnico tecnico, Tarea tarea, LocalDate fecha, String rol) {
        this.codTecnico = tecnico.getCodUsuario();
        this.codIncidencia = tarea.getCodIncidencia();
        this.numOrden = tarea.getNumOrden();
        this.fecha = fecha;
        this.rol = rol;
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

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTrabajoRealizado() {
        return rol;
    }

    public void setTrabajoRealizado(String trabajoRealizado) {
        this.rol = trabajoRealizado;
    }

    @Override
    public String toString() {
        return "Participa{" +
                "codTecnico='" + codTecnico + '\'' +
                ", codIncidencia='" + codIncidencia + '\'' +
                ", numOrden='" + numOrden + '\'' +
                ", fecha=" + fecha +
                ", trabajoRealizado='" + rol + '\'' +
                '}';
    }
}
