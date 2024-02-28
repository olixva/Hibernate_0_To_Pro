package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "tareas")
public class Tarea {

    // Heredada de Incidencia
    @Id
    @ManyToOne
    @JoinColumn(name = "cod_incidencia")
    private Incidencia codIncidencia;

    @Id
    @Column(name = "num_orden")
    private String numOrden;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany
    @JoinTable(name = "participa",
            joinColumns = {
                    @JoinColumn(name = "num_orden" , referencedColumnName = "num_orden"),
                    @JoinColumn(name = "cod_incidencia", referencedColumnName = "cod_incidencia")
            },
            inverseJoinColumns = @JoinColumn(name = "cod_tecnico", referencedColumnName = "cod_usuario"))
    private Set<Tecnico> tecnicos = new HashSet<>();

    public Tarea() {
    }

    public Tarea(Incidencia codIncidencia, String numOrden, String descripcion) {
        this.codIncidencia = codIncidencia;
        this.numOrden = numOrden;
        this.descripcion = descripcion;
    }

    public void setIncidencia(Incidencia codIncidencia) {
        this.codIncidencia = codIncidencia;
    }

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(Set<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public String getCodIncidencia() {
        return codIncidencia.getCodIncidencia();
    }

    @Override
    public String toString() {
        return "Tarea [codIncidencia=" + codIncidencia + ", descripcion=" + descripcion + ", numOrden=" + numOrden + "]";
    }

}
