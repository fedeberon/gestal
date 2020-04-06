package com.ideaas.services.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by federicoberon on 04/02/2020.
 */
@Entity
@Table(name = "ITEMS_EVALUADOS")
public class ItemEvaluado implements Serializable{

    @Id
    @Column(name = "IEV_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "IEV_ITEM_ID", nullable = false)
    private Item item;

    @Column(name = "IEV_RATING")
    private Float rating;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "IEV_EDC_ID", nullable = false)
    private EvaluacionDelColaborador evaluacionDelColaborador;

    @Column(name = "IEV_RATING_CONSIDERACION")
    private Float ratingConsideracion;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public EvaluacionDelColaborador getEvaluacionDelColaborador() {
        return evaluacionDelColaborador;
    }

    public void setEvaluacionDelColaborador(EvaluacionDelColaborador evaluacionDelColaborador) {
        this.evaluacionDelColaborador = evaluacionDelColaborador;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Float getRatingConsideracion() {
        return ratingConsideracion;
    }

    public void setRatingConsideracion(Float ratingConsideracion) {
        this.ratingConsideracion = ratingConsideracion;
    }
}
