package com.ideaas.services.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by federicoberon on 03/02/2020.
 */
@Entity
@Table(name = "ITEMS")
public class Item implements Serializable{

    @NotNull(message = "Please enter id")
    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ITEM_VALUE")
    private String value;

    @JsonIgnore
    @Column(name = "ITEM_SCORE")
    private Float score;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_EVA_ID", nullable = false)
    private Evaluacion evaluacion;

    @JsonIgnore
    @Column(name = "ITEM_INAVLID_SCORE")
    private boolean invalidaEvaluacion = false;

    @ElementCollection
    @OrderBy
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_CON_ID", nullable = false)
    private List<Consideracion> consideraciones;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public boolean isInvalidaEvaluacion() {
        return invalidaEvaluacion;
    }

    public void setInvalidaEvaluacion(boolean invalidaEvaluacion) {
        this.invalidaEvaluacion = invalidaEvaluacion;
    }

    public List<Consideracion> getConsideraciones() {
        return consideraciones;
    }

    public void setConsideraciones(List<Consideracion> consideraciones) {
        this.consideraciones = consideraciones;
    }
}
