package com.ideaas.services.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by federicoberon on 30/01/2020.
 */
@Entity
@Table(name = "COLABORADORES")
public class Colaborador implements Serializable{

    @Id
    @Column(name = "COL_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "COL_NAME")
    @NotNull(message = "Campo requerido")
    @NotBlank(message = "Campo requerido")
    private String name;

    @Column(name = "COL_LAST_NAME")
    @NotNull(message = "Campo requerido")
    @NotBlank(message = "Campo requerido")
    private String lastName;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "COL_ROL_ID", nullable = false)
    private Rol rol;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
