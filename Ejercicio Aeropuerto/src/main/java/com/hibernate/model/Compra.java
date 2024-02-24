package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "compra")
public class Compra {

    @Id
    @Column(name = "avion_n_registro", insertable = false, updatable = false)
    private String avionNRegistro;

    @Id
    @Column(name = "propietario_nss", insertable = false, updatable = false)
    private String propietarioNss;

    private LocalDate fechaCompra;

    public Compra() {
    }

    public Compra(Avion avion, Propietario propietario, LocalDate fechaCompra) {
        this.avionNRegistro = avion.getnRegistro();
        this.propietarioNss = propietario.getNss();
        this.fechaCompra = fechaCompra;
    }

    public String getAvionNRegistro() {
        return avionNRegistro;
    }

    public void setAvionNRegistro(String avionNRegistro) {
        this.avionNRegistro = avionNRegistro;
    }

    public String getPropietarioNss() {
        return propietarioNss;
    }

    public void setPropietarioNss(String propietarioNss) {
        this.propietarioNss = propietarioNss;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "avionNRegistro='" + avionNRegistro + '\'' +
                ", propietarioNss='" + propietarioNss + '\'' +
                ", fechaCompra=" + fechaCompra +
                '}';
    }
}