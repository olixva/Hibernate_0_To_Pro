package com.hibernate.model;

import jakarta.persistence.Entity;

@Entity
public class Propietario extends Persona{

    private String telefono;

    public Propietario(String nss, String nombre, String direccion, String telefono) {
        super(nss, nombre, direccion);
        this.telefono = telefono;
    }

    public Propietario() {
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "telefono='" + telefono + '\'' +
                '}';
    }
}
