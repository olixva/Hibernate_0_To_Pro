package com.iescierva.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @Column(name = "cod_depto")
    private String codDepto;

    @Column(name = "nombre_depto")
    private String nombreDepto;

    // Relación uno a muchos con Empleado
    @OneToMany(mappedBy = "departamento")
    private Set<Empleado> empleados = new HashSet<>();

    public Departamento() {
    }

    public Departamento(String codDepto, String nombreDepto) {
        this.codDepto = codDepto;
        this.nombreDepto = nombreDepto;
    }

    public String getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Departamento{" + "codDepto=" + codDepto + ", nombreDepto=" + nombreDepto + ", empleados=" + empleados + '}';
    }
}
