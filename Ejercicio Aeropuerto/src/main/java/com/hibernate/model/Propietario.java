package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "propietarios")
public class Propietario extends Persona{

    @Column(name = "telefono")
    private String telefono;

    @ManyToMany(mappedBy = "propietarios")
    private Set<Avion> aviones = new HashSet<>();

    public Propietario() {
    }

    public Propietario(String nss, String nombre, String direccion, String telefono) {
        super(nss, nombre, direccion);
        this.telefono = telefono;
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