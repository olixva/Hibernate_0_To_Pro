package com.iescierva.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
@Inheritance(strategy = InheritanceType.JOINED)
public class Empleado {

    @Id
    @Column(name = "num_matricula")
    private String numMatricula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "cod_depto", referencedColumnName = "cod_depto")
    private Departamento departamento;

    public Empleado() {
    }

    public Empleado(String numMatricula, String nombre, String direccion, Departamento departamento) {
        this.numMatricula = numMatricula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.departamento = departamento;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" + "numMatricula=" + numMatricula + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
}
