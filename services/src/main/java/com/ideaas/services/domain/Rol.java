package com.ideaas.services.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by federicoberon on 04/02/2020.
 */
@Entity
@Table(name = "ROLES")
public class Rol {


    @Id
    @Column(name = "ROL_ID")
    private Long id;

    @Column(name = "ROL_NAME")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "rol_id", referencedColumnName = "ROL_ID"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "PRI_ID"))
    private Collection<Privilege> privileges;

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

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
}
