package com.ideaas.services.domain;

import javax.persistence.*;

/**
 * Created by federicoberon on 04/02/2020.
 */
@Entity
@Table(name = "ITEMS_EVALUADOS")
public class ItemEvaluado {

    @Id
    @Column(name = "IEV_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "IEV_ITEM_ID", nullable = false)
    private Item item;

    @Column(name = "IEV_rating")
    private Float rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IEV_EDC_ID", nullable = false)
    private EvaluacionDelColaborador evaluacionDelColaborador;

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
}
