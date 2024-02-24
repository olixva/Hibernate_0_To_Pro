package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @ManyToOne
    @JoinColumn(name = "cod_incidencia")
    private Incidencia codIncidencia;

    @Id
    @Column(name = "num_orden")
    private Integer numOrden;
    

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany
    @JoinTable(name = "trabaja", 
        joinColumns = {
            @JoinColumn(name = "cod_incidencia"),
            @JoinColumn(name = "num_orden")
        }, 
        inverseJoinColumns = @JoinColumn(name = "cod_tecnico"))
    private Set<Tecnico> tecnicos = new HashSet<>();

    public Tarea() {
    }

    public Tarea(Incidencia codIncidencia, Integer numOrden, String descripcion) {
        this.codIncidencia = codIncidencia;
        this.numOrden = numOrden;
        this.descripcion = descripcion;
    }

    public Set<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(Set<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Incidencia getCodIncidencia() {
        return codIncidencia;
    }

    public void setCodIncidencia(Incidencia codIncidencia) {
        this.codIncidencia = codIncidencia;
    }

    public Integer getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(Integer numOrden) {
        this.numOrden = numOrden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tarea [codIncidencia=" + codIncidencia + ", descripcion=" + descripcion + ", numOrden=" + numOrden + "]";
    }

}
