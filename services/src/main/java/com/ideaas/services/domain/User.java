package com.ideaas.services.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "USERS")
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USU_ID")
    private Long id;

    @Column(name = "USU_USERNAME")
    @NotBlank(message = "No se puede cargar con espacios vacios")
    private String username;

    @Column(name = "USU_PASSWORD")
    @NotBlank(message = "No se puede cargar con espacios vacios")
    private String password;

    @Column(name = "users_mail")
    @NotBlank(message = "No se puede cargar con espacios vacios")
    @Email
    private String mail;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "USU_ID", referencedColumnName = "USU_USERNAME"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "ROL_ID"))
    private Collection<Rol> roles;

    public User() {}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}