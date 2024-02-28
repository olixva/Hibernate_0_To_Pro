package com.ingeniero.model;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Socio {

    @Id
    @Column(name = "cod_socio")
    private String codSocio;
    @NaturalId
    private String dni;
    private String nombre;

    @ManyToMany(mappedBy = "socios")
    private Set<Articulo> articulos = new HashSet<Articulo>();

    private String apellido;

    private String direccion;

    @ElementCollection
    private Set<String> telefono = new HashSet<>();

    public Socio() {
    }

    public Socio(String codSocio, String dni, String nombre, String apellido, String direccion, List<String> telefono) {
        this.codSocio = codSocio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = new HashSet<>(telefono);
    }

    public String getCodSocio() {
        return codSocio;
    }

    public void setCodSocio(String codSocio) {
        this.codSocio = codSocio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<String> getTelefono() {
        return telefono;
    }

    public void setTelefono(Set<String> telefono) {
        this.telefono = telefono;
    }

    public Set<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(Set<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "codSocio='";
    }
}
