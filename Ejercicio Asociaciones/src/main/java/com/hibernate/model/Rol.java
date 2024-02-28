package com.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @Column(name = "cod_rol")
    private String codRol;

    @Column(name = "descripcion")
    private String descripcion;


}
