package com.ideaas.services.domain;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Benja on 22/3/2020.
 */
@Entity
@Table(name = "SUCURSALES")
public class Sucursal implements Serializable {


    @Id
    @Column(name = "SUCURSAL ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SUCURSAL_NAME")
    @NotBlank(message = "No se puede cargar con espacios vacios")
    private String name;

    @Column(name = "SUC_DIRECCION")
    @NotBlank(message = "No se puede cargar con espacios vacios")
    private String direction;

    @Column (name = "SUC TELEFONO")
    @NotBlank(message= "No se puede cargar con espacios vacios");
    private Long telephone;

    @Column (name ="SUC MAIL")
    @NotBlank(messeage= "No se puede cargar con espacios vacios");
    private String mail;

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

    public String getDirection(){ return direction; }

    public void setDirection(String direction) { this.direction = direction; }

    public Long getTelephone() { return telephone; }

    public void setTelephone (Long telephone) { this.telephone = telephone; }

    public String getMail () { return mail; }

    public void setMail(String mail) { this.mail = mail; }

}
