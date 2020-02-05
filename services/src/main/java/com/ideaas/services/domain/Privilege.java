package com.ideaas.services.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by federicoberon on 04/02/2020.
 */
@Entity
@Table(name = "PRIVILEGES")
public class Privilege {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRI_ID")
    private Long id;

    @Column(name = "PRI_NAME")
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Rol> roles;

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

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }
}
