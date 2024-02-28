package com.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @Column(name = "codigo_rol")
    private String codRol;

    @Column(name = "descripcion")
    private String descripcion;

    public Rol() {
    }

    public Rol(String codRol, String descripcion) {
        this.codRol = codRol;
        this.descripcion = descripcion;
    }

    public String getCodRol() {
        return codRol;
    }

    public void setCodRol(String codRol) {
        this.codRol = codRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Rol [codRol=" + codRol + ", descripcion=" + descripcion + "]";
    }

}
