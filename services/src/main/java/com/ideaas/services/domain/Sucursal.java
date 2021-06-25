package com.ideaas.services.domain;
import com.ideaas.services.bean.State;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Benja on 22/3/2020.
 */
@Entity
@Table(name = "SUCURSALES")
public class Sucursal implements Serializable {


    @Id
    @Column(name = "SUC_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SUC_NAME")
    private String name;

    @Column(name = "SUC_DIRECCION")
    private String direction;

    @Column (name = "SUC_TELEFONO")
    private String telephone;

    @Column (name ="SUC_MAIL")
    private String mail;

    @Enumerated(EnumType.STRING)
    private State state;

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

    public String getTelephone() { return telephone; }

    public void setTelephone (String telephone) { this.telephone = telephone; }

    public String getMail () { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
