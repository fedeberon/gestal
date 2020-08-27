package com.ideaas.services.domain;

import com.ideaas.services.bean.State;

import javax.persistence.*;
import java.util.List;

/**
 * Created by federicoberon on 03/02/2020.
 */
@Entity
@Table(name = "EVALUACIONES")
public class Evaluacion {

    @Id
    @Column(name = "EVA_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evaluacion", cascade = CascadeType.PERSIST)
    @ElementCollection
    @OrderBy
    private List<Item> items;

    @Column(name = "EVA_COMENTARIOS")
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "ROL_ID")
    private Puesto puesto;

    @Enumerated(EnumType.STRING)
    private State state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
