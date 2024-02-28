package com.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "telefonos")
public class Telefono {

    @Id
    @Column(name = "cod_telefono")
    private String codTelefono;

    @Column(name = "num_telf")
    private String numTelf;

    @ManyToOne
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;

    public Telefono() {
    }

    public Telefono(String codTelefono, String numTelf, Usuario usuario) {
        this.codTelefono = codTelefono;
        this.numTelf = numTelf;
        this.usuario = usuario;
    }

    public String getCodTelefono() {
        return codTelefono;
    }

    public void setCodTelefono(String codTelefono) {
        this.codTelefono = codTelefono;
    }

    public String getNumTelf() {
        return numTelf;
    }

    public void setNumTelf(String numTelf) {
        this.numTelf = numTelf;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "codTelefono='" + codTelefono + '\'' +
                ", numTelf='" + numTelf + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
