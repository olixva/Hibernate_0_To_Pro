package com.hibernate.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Participa {

    @Id
    @Column(name = "num_afi")
    private String numAfi;
    @Id
    @Column(name = "codigo_proyecto")
    private String codigoProyecto;
    @Id
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @ManyToOne
    @JoinColumn(name = "cod_rol")
    private Rol codRol;

    @Column(name = "fecha_fin", nullable = true)
    private LocalDate fechaFin;

    public Participa() {
    }

    public Participa(String numAfi, String codigoProyecto, Rol codRol) {
        this.numAfi = numAfi;
        this.codigoProyecto = codigoProyecto;
        this.codRol = codRol;
    }

    public String getNumAfi() {
        return numAfi;
    }

    public void setNumAfi(String numAfi) {
        this.numAfi = numAfi;
    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public Rol getCodRol() {
        return codRol;
    }

    public void setCodRol(Rol codRol) {
        this.codRol = codRol;
    }

    @Override
    public String toString() {
        return "Participa{" + "numAfi=" + numAfi + ", codigoProyecto=" + codigoProyecto + ", codRol=" + codRol + '}';
    }

}
