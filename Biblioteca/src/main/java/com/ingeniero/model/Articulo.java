package com.ingeniero.model;

import com.github.javafaker.Bool;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Articulo {
    @Id
    @Column(name = "cod_art")
    private String codArt;

    @ManyToOne
    @JoinColumn(name = "cod_obra", nullable = false)
    private Obra obra;

    private Boolean deteriorado;

    private String comentario;

    @ManyToMany
    @JoinTable(
            name = "prestar",
            joinColumns = @JoinColumn(name = "cod_art"),
            inverseJoinColumns = @JoinColumn(name = "cod_soc")
    )
    private Set<Socio> socios = new HashSet<Socio>();

    public Articulo() {
    }

    public Articulo(String codArt, Obra obra, Boolean deteriado, String comentario) {
        this.codArt = codArt;
        this.obra = obra;
        this.deteriorado = deteriado;
        this.comentario = comentario;
    }

    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    public Boolean getDeteriorado() {
        return deteriorado;
    }

    public void setDeteriorado(Boolean deteriado) {
        this.deteriorado = deteriado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
