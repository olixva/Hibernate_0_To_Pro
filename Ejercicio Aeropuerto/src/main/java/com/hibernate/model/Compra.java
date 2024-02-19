package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "compra")
public class Compra {

    @Id
    @Column(name = "avion_n_registro", insertable = false, updatable = false)
    private int avionNRegistro;

    @Id
    @Column(name = "propietario_nss", insertable = false, updatable = false)
    private int propietarioNss;

    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;

    public Compra() {
    }

    public Compra(int avionNRegistro, int propietarioNss, LocalDate fechaCompra) {
        this.avionNRegistro = avionNRegistro;
        this.propietarioNss = propietarioNss;
        this.fechaCompra = fechaCompra;
    }

    public int getAvionNRegistro() {
        return avionNRegistro;
    }

    public void setAvionNRegistro(int avionNRegistro) {
        this.avionNRegistro = avionNRegistro;
    }

    public int getPropietarioNss() {
        return propietarioNss;
    }

    public void setPropietarioNss(int propietarioNss) {
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
                "avionNRegistro=" + avionNRegistro +
                ", propietarioNss=" + propietarioNss +
                ", fechaCompra=" + fechaCompra +
                '}';
    }
}
