package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pilotos")
public class Piloto extends Persona{

    @Column(name = "n_lic")
    private String nLic;

    @ManyToMany(mappedBy = "pilotos")
    private Set<Tipo> tipos = new HashSet<>();

    public Piloto(String nss, String nombre, String direccion, String nLic) {
        super(nss, nombre, direccion);
        this.nLic = nLic;
    }

    public Piloto() {
    }

    public String getnLic() {
        return nLic;
    }

    public void setnLic(String nLic) {
        this.nLic = nLic;
    }

    public Set<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(Set<Tipo> tipos) {
        this.tipos = tipos;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "nLic='" + nLic + '\'' +
                '}';
    }
}
