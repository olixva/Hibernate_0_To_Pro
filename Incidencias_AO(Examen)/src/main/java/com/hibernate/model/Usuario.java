package com.hibernate.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hibernate.model.Telefono;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @Column(name = "cod_usuario")
    private String codUsuario;

    @NaturalId
    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "email1", nullable = true)
    private String email;

    @Column(name = "email2", nullable = true)
    private String email2;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @OneToMany(mappedBy = "usuario")
    private Set<Telefono> telefonos = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Incidencia> incidencias = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String codUsuario, String login, String email, String email2, String nombre, String apellidos) {
        this.codUsuario = codUsuario;
        this.login = login;
        this.email = email;
        this.email2 = email2;
        this.nombre = nombre;
        this.apellidos = apellidos;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public Set<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(Set<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codUsuario='" + codUsuario + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefonos=" + telefonos +
                ", incidencias=" + incidencias +
                '}';
    }
}
