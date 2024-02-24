package com.hibernate.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "trabaja")
public class Trabaja {

    // Tecnico
    @Id
    @Column(name = "cod_tecnico")
    private String codTecnico;

    // Tarea
    @Id
    @Column(name = "num_orden")
    private Integer numOrden;

    // Rol
    @ManyToOne
    @JoinColumn(name = "cod_rol")
    private Rol codRol;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "trabajo_realizado")
    private String trabajoRealizado;

    public Trabaja() {
    }

    public Trabaja(Tecnico tecnico, Tarea tarea, Rol codRol,
            LocalDate fecha, String trabajoRealizado) {
        this.codTecnico = tecnico.getCodUsuario();
        this.numOrden = tarea.getNumOrden();
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
        return "Trabaja [codTecnico=" + codTecnico + ", codRol=" + codRol + ", fecha=" + fecha + ", numOrden=" + numOrden
                + ", trabajoRealizado=" + trabajoRealizado + "]";
    }
    
}
