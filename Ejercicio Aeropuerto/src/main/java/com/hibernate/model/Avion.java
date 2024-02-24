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
    private String nRegistro;

    @NaturalId
    @Column(name = "matricula")
    private String matricula;

    @Column(name = "fecha_reg")
    private LocalDate fechaReg;

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

    public Avion() {
    }

    public Avion(String nRegistro, String matricula, LocalDate fechaReg, LocalDate fechaConstruccion, Hangar hangar, Tipo tipo) {
        this.nRegistro = nRegistro;
        this.matricula = matricula;
        this.fechaReg = fechaReg;
        this.fechaConstruccion = fechaConstruccion;
        this.hangar = hangar;
        this.tipo = tipo;
    }

    public String getnRegistro() {
        return nRegistro;
    }

    public void setnRegistro(String nRegistro) {
        this.nRegistro = nRegistro;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(LocalDate fechaReg) {
        this.fechaReg = fechaReg;
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

    @Override
    public String toString() {
        return "Avion{" +
                "nRegistro='" + nRegistro + '\'' +
                ", matricula='" + matricula + '\'' +
                ", fechaReg=" + fechaReg +
                ", fechaConstruccion=" + fechaConstruccion +
                ", hangar=" + hangar +
                ", tipo=" + tipo +
                '}';
    }
}