package com.ideaas.services.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by federicoberon on 04/02/2020.
 */
@Entity
@Table(name = "EVALUACIONES_DE_COLABORADORES")
public class EvaluacionDelColaborador {


    @Id
    @Column(name = "EDC_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "EDC_USER_ID", nullable = false)
    private User usuarioEvaluado;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "EDC_ROL_ID", nullable = false)
    private Rol rolEvaluado;

    @Column(name = "EDC_FECHA")
    private LocalDateTime fecha;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evaluacionDelColaborador")
    private List<ItemEvaluado> itemEvaluados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuarioEvaluado() {
        return usuarioEvaluado;
    }

    public void setUsuarioEvaluado(User usuarioEvaluado) {
        this.usuarioEvaluado = usuarioEvaluado;
    }

    public Rol getRolEvaluado() {
        return rolEvaluado;
    }

    public void setRolEvaluado(Rol rolEvaluado) {
        this.rolEvaluado = rolEvaluado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<ItemEvaluado> getItemEvaluados() {
        return itemEvaluados;
    }

    public void setItemEvaluados(List<ItemEvaluado> itemEvaluados) {
        this.itemEvaluados = itemEvaluados;
    }
}
