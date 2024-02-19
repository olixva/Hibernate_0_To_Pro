package com.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    private String nss;

    private String nombre;

    private String direccion;

    public Persona(String nss, String nombre, String direccion) {
        this.nss = nss;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Persona() {
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
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
}
