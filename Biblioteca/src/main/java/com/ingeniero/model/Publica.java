package com.ingeniero.model;


import jakarta.persistence.*;

@Entity(name = "publica")
public class Publica {

    @Id
    @Column(name = "cod_autor")
    private String codAutor;
    @Id
    @Column(name = "cod_obra")
    private String codObra;

    @Enumerated(EnumType.STRING)
    private Roles rol;
    public Publica() {
    }

    public Publica(Autor autor, Obra obra, Roles rol) {
        this.codAutor = autor.getCodAutor();
        this.codObra = obra.getCodObra();
        this.rol = rol;
    }

    public String getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(String codAutor) {
        this.codAutor = codAutor;
    }

    public String getCodObra() {
        return codObra;
    }

    public void setCodObra(String codObra) {
        this.codObra = codObra;
    }
    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }



}
