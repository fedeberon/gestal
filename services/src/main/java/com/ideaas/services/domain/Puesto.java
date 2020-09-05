package com.ideaas.services.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by federicoberon on 04/02/2020.
 */
@Entity
@Table(name = "PUESTOS")
public class Puesto implements Serializable{


    @Id
    @Column(name = "PUESTO_ID", unique=true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PUESTO_NAME")
    @NotBlank(message = "No se puede cargar con espacios vacios")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
