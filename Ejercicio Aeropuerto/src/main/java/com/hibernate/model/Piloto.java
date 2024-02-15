package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.hibernate.annotations.NaturalId;

@Entity
public class Piloto extends Persona{

    @NaturalId
    @Column(name = "n_lic")
    private String nLic;

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

    @Override
    public String toString() {
        return "Piloto{" +
                "nLic='" + nLic + '\'' +
                '}';
    }
}
