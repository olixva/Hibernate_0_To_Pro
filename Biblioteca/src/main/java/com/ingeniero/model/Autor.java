package com.ingeniero.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Autor {

    @Id
    private String codAutor;
    private String nombre;
    private String pais;

    @ManyToMany(mappedBy = "autores")
    private Set<Obra> obras = new HashSet<Obra>();

    public Autor() {
    }

    public Autor(String cod_autor, String nombre, String pais) {
        this.codAutor = cod_autor;
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(String cod_autor) {
        this.codAutor = cod_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
