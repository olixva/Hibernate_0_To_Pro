package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "mantiene")
public class Mantiene {

    @Id
    @Column(name = "avion_n_registro", insertable = false, updatable = false)
    private String avionNRegistro;

    @Id
    @Column(name = "mecanico_nss", insertable = false, updatable = false)
    private String mecanicoNss;

    @Id
    private String codTrabajo;

    private LocalDate fecha;

    private Integer nHoras;

    public Mantiene() {
    }

    public Mantiene(String avionNRegistro, String mecanicoNss, String codTrabajo, LocalDate fecha, Integer nHoras) {
        this.avionNRegistro = avionNRegistro;
        this.mecanicoNss = mecanicoNss;
        this.codTrabajo = codTrabajo;
        this.fecha = fecha;
        this.nHoras = nHoras;
    }

    public String getAvionNRegistro() {
        return avionNRegistro;
    }

    public void setAvionNRegistro(String avionNRegistro) {
        this.avionNRegistro = avionNRegistro;
    }

    public String getMecanicoNss() {
        return mecanicoNss;
    }

    public void setMecanicoNss(String mecanicoNss) {
        this.mecanicoNss = mecanicoNss;
    }

    public String getCodTrabajo() {
        return codTrabajo;
    }

    public void setCodTrabajo(String codTrabajo) {
        this.codTrabajo = codTrabajo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getnHoras() {
        return nHoras;
    }

    public void setnHoras(Integer nHoras) {
        this.nHoras = nHoras;
    }

    @Override
    public String toString() {
        return "Mantiene{" +
                "avionNRegistro='" + avionNRegistro + '\'' +
                ", mecanicoNss='" + mecanicoNss + '\'' +
                ", codTrabajo='" + codTrabajo + '\'' +
                ", fecha=" + fecha +
                ", nHoras=" + nHoras +
                '}';
    }
}