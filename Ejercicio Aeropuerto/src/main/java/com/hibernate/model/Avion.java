package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.NaturalId;

import java.util.Date;

@Entity
public class Avion {

    @Id
    @Column(name = "N_registro")
    private int NRegistro;

    @NaturalId
    private String matriucla;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "fecha_construccion")
    private Date fechaConstruccion;

    public Avion(int NRegistro, String matriucla, Date fechaRegistro, Date fechaConstruccion) {
        this.NRegistro = NRegistro;
        this.matriucla = matriucla;
        this.fechaRegistro = fechaRegistro;
        this.fechaConstruccion = fechaConstruccion;
    }

    public Avion() {
    }

    public int getNRegistro() {
        return NRegistro;
    }

    public void setNRegistro(int NRegistro) {
        this.NRegistro = NRegistro;
    }

    public String getMatriucla() {
        return matriucla;
    }

    public void setMatriucla(String matriucla) {
        this.matriucla = matriucla;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaConstruccion() {
        return fechaConstruccion;
    }

    public void setFechaConstruccion(Date fechaConstruccion) {
        this.fechaConstruccion = fechaConstruccion;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "NRegistro=" + NRegistro +
                ", matriucla='" + matriucla + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaConstruccion=" + fechaConstruccion +
                '}';
    }
}
