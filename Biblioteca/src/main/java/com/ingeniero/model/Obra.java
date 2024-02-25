package com.ingeniero.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Obra {
    @Id
    @Column(name = "cod_obra")
    private String codObra;


    @OneToMany(mappedBy = "obra")
    private List<Articulo> articulos;

    @ManyToMany
    @JoinTable(
            name = "publica",
            joinColumns = @JoinColumn(name = "cod_obra"),
            inverseJoinColumns = @JoinColumn(name = "cod_autor")
    )
    private List<Autor> autores;

    private String nombre;

    private LocalDate anyo;

    public Obra() {
    }

    public Obra(String codObra, String nombre, LocalDate anyo) {
        this.codObra = codObra;
        this.nombre = nombre;
        this.anyo = anyo;
    }

    public String getCodObra() {
        return codObra;
    }

    public void setCodObra(String codObra) {
        this.codObra = codObra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getAnyo() {
        return anyo;
    }

    public void setAnyo(LocalDate anyo) {
        this.anyo = anyo;
    }

    @Override
    public String toString() {
        return "Obra{" +
                "codObra=" + codObra +
                ", nombre='" + nombre + '\'' +
                ", anyo=" + anyo +
                '}';
    }


}
