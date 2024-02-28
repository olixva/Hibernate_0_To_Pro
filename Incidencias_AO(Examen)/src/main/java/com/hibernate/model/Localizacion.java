package com.hibernate.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "localizaciones")
public class Localizacion {

    @Id
    @Column(name = "cod_localizacion")
    private String codLocalizacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "direccion", nullable = true)
    private String direccion;

    // Incidencias de la localizacion
    @OneToMany(mappedBy = "localizacion")
    private Set<Incidencia> incidencias = new HashSet<Incidencia>();

    // Localizacion a la que pertenece
    @ManyToOne
    @JoinColumn(name = "cod_localizacion_padre", nullable = true)
    private Localizacion localizacionPadre;

    public Localizacion() {
    }

    public Localizacion(String codLocalizacion, String descripcion, String direccion, Localizacion localizacionPadre) {
        this.codLocalizacion = codLocalizacion;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.localizacionPadre = localizacionPadre;
    }

    public Localizacion(String codLocalizacion, String descripcion, String direccion) {
        this.codLocalizacion = codLocalizacion;
        this.descripcion = descripcion;
        this.direccion = direccion;
    }

    public String getCodLocalizacion() {
        return codLocalizacion;
    }

    public void setCodLocalizacion(String codLocalizacion) {
        this.codLocalizacion = codLocalizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(Set<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }

    public Localizacion getLocalizacionPadre() {
        return localizacionPadre;
    }

    public void setLocalizacionPadre(Localizacion localizacionPadre) {
        this.localizacionPadre = localizacionPadre;
    }
}
