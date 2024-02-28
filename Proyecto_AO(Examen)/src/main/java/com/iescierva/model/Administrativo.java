package com.iescierva.model;

import jakarta.persistence.*;

@Entity
@Table(name = "administrativos")
public class Administrativo extends Empleado{

    @Column(name = "puesto")
    private String puesto;

    public Administrativo() {
    }

    public Administrativo(String numMatricula, String nombre, String direccion, Departamento departamento, String puesto) {
        super(numMatricula, nombre, direccion, departamento);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Administrativo{" + "puesto=" + puesto + '}';
    }
}
