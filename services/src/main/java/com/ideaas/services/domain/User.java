package com.ideaas.services.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USU_USERNAME")
    private String username;

    @Column(name = "USU_PASSWORD")
    private String password;

    @Column(name = "users_mail")
    private String mail;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "USU_USERNAME"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "ROL_ID"))
    private Collection<Rol> roles;

    public User() {}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }
}