package com.hibernate.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "apoya")
public class Apoya {

    @Id
    @Column(name = "codigo_proyecto")
    private String codigoProyecto;

    @Id
    @Column(name = "num_afi")
    private String numAfi;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "importe")
    private Double importe;

    // @ManyToOne
    // @JoinColumn(name = "codigo_proyecto", insertable = false, updatable = false)
    // private Proyecto proyecto;

    // @ManyToOne
    // @JoinColumn(name = "num_afi", insertable = false, updatable = false)
    // private Socio socio;

    public Apoya() {
    }

    public Apoya(String codigoProyecto, String numAfi) {
        this.codigoProyecto = codigoProyecto;
        this.numAfi = numAfi;
    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNumAfi() {
        return numAfi;
    }

    public void setNumAfi(String numAfi) {
        this.numAfi = numAfi;
    }

    @Override
    public String toString() {
        return "Apoya{" + "codigoProyecto=" + codigoProyecto + ", numAfi=" + numAfi + '}';
    }

}
