package com.ingeniero.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "prestar")
public class Prestar {


    @Id
    @Column(name = "cod_art")
    private String codArt;
    @Id
    @Column(name = "cod_soc")
    private String codSoc;
    @Id
    @Column(name = "fech_prest")
    private LocalDate fechPrest;
    @Column(name = "fech_dev", nullable = true)
    private LocalDate fechDev;

    @Column(name = "fech_tope")
    private LocalDate fechTope;

    public Prestar() {
    }

    public Prestar(Articulo articulo, Socio socio, LocalDate fechPrest, LocalDate fechDev, LocalDate fechTope) {
        this.codArt = articulo.getCodArt();
        this.codSoc = socio.getCodSocio();
        this.fechPrest = fechPrest;
        this.fechDev = fechDev;
        this.fechTope = fechTope;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    public void setCodSoc(String codSoc) {
        this.codSoc = codSoc;
    }

    public LocalDate getFechPrest() {
        return fechPrest;
    }

    public void setFechPrest(LocalDate fechPrest) {
        this.fechPrest = fechPrest;
    }

    public LocalDate getFechDev() {
        return fechDev;
    }

    public void setFechDev(LocalDate fechDev) {
        this.fechDev = fechDev;
    }

    public LocalDate getFechTope() {
        return fechTope;
    }

    public void setFechTope(LocalDate fechTope) {
        this.fechTope = fechTope;
    }

    @Override
    public String toString() {
        return "Prestar{" +
                "codArt=" + codArt +
                ", codSoc=" + codSoc +
                ", fechPrest=" + fechPrest +
                ", fechDev=" + fechDev +
                ", fechTope=" + fechTope +
                '}';
    }
}