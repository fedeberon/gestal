package com.ideaas.services.domain;

import com.ideaas.services.enumeradores.State;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by federicoberon on 30/01/2020.
 */
@Entity
@Table(name = "COLABORADORES")
public class Colaborador implements Serializable {

    @Id
    @Column(name = "COL_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "COL_NAME")
    @NotBlank(message = "No se puede cargar con espacios vacios")
    private String name;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "COL_PUE_ID", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Puesto puesto;

    @Column(name = "COL_USERNAME")
    private String username;

    @Column(name = "COL_EMAIL", unique = true)
    private String email;

    @Column(name = "COL_PASSWORD")
    @NotBlank(message = "No se puede cargar con espacios vacios")
    private String password;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "COL_SUC_ID", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Sucursal sucursal;

    @Column(name = "COL_ENABLED")
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "USERS_ROLES",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Rol> roles = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "RESET_PASSWORD_TOKEN")
    private String resetPasswordToken;

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

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }
}
