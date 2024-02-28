package com.hibernate.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @Column(name = "cod_usuario")
    private String codUsuario;

    @NaturalId
    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "email2", nullable = true)
    private String email2;

    @ElementCollection
    private List<String> telefonos = new ArrayList<String>();

    @OneToMany(mappedBy = "usuario")
    private Set<Incidencia> incidencias = new HashSet<Incidencia>();

    public Usuario() {
    }

    public Usuario(String codUsuario, String login, String nombre, String email, String email2, List<String> telefonos) {
        this.codUsuario = codUsuario;
        this.login = login;
        this.nombre = nombre;
        this.email = email;
        this.email2 = email2;
        this.telefonos = telefonos;
    }

    public Usuario(String codUsuario, String login, String nombre) {
        this.codUsuario = codUsuario;
        this.login = login;
        this.nombre = nombre;
    }

    public Usuario(String codUsuario, String login, String nombre, String email) {
        this.codUsuario = codUsuario;
        this.login = login;
        this.nombre = nombre;
        this.email = email;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "Usuario [codUsuario=" + codUsuario + ", login=" + login + ", nombre=" + nombre + ", email=" + email
                + ", email2=" + email2 + ", telefonos=" + telefonos + "]";
    }

}
