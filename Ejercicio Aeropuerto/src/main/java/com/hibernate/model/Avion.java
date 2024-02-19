package com.hibernate.model;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "aviones")
public class Avion {

    @Id
    @Column(name = "n_registro")
    private int nRegistro;

    @NaturalId
    private String matriucla;

    @Column(name = "fecha_reg")
    private LocalDate fechaRegistro;

    @Column(name = "fecha_construccion")
    private LocalDate fechaConstruccion;

    @ManyToOne
    @JoinColumn(name = "hangar_cod", nullable = false)
    private Hangar hangar;

    @ManyToOne
    @JoinColumn(name = "tipo_modelo", nullable = false)
    private Tipo tipo;

    @ManyToMany
    @JoinTable(
            name = "mantiene",
            joinColumns = @JoinColumn(name = "avion_n_registro"),
            inverseJoinColumns = @JoinColumn(name = "mecanico_nss")
    )
    private Set<Mecanico> mecanicos = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "compra",
            joinColumns = @JoinColumn(name = "avion_n_registro"),
            inverseJoinColumns = @JoinColumn(name = "propietario_nss")
    )
    private Set<Propietario> propietarios = new HashSet<>();

    public Avion(int nRegistro, String matriucla, LocalDate fechaRegistro, LocalDate fechaConstruccion, Hangar hangar, Tipo tipo) {
        this.nRegistro = nRegistro;
        this.matriucla = matriucla;
        this.fechaRegistro = fechaRegistro;
        this.fechaConstruccion = fechaConstruccion;
        this.hangar = hangar;
        this.tipo = tipo;
    }

    public Avion() {
    }

    public String getMatriucla() {
        return matriucla;
    }

    public void setMatriucla(String matriucla) {
        this.matriucla = matriucla;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaConstruccion() {
        return fechaConstruccion;
    }

    public void setFechaConstruccion(LocalDate fechaConstruccion) {
        this.fechaConstruccion = fechaConstruccion;
    }

    public Hangar getHangar() {
        return hangar;
    }

    public void setHangar(Hangar hangar) {
        this.hangar = hangar;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getnRegistro() {
        return nRegistro;
    }

    public void setnRegistro(int nRegistro) {
        this.nRegistro = nRegistro;
    }

    public Set<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(Set<Mecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }

    public Set<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(Set<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "NRegistro=" + nRegistro +
                ", matriucla='" + matriucla + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaConstruccion=" + fechaConstruccion +
                '}';
    }
}
