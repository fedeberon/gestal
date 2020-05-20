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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IEV_EDC_ID", nullable = false)
    private EvaluacionDelColaborador evaluacionDelColaborador;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IEV_CON_ID", nullable = false)
    private List<ConsideracionItemEvaluado> consideracionItemEvaluados;

    @Column(name = "IEV_CON_ITEM_EVALUADO")
    private Long valorConsideracionItemEvaluados;

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

    public List<ConsideracionItemEvaluado> getConsideracionItemEvaluados() {
        return consideracionItemEvaluados;
    }

    public void setConsideracionItemEvaluados(List<ConsideracionItemEvaluado> consideracionItemEvaluados) {
        this.consideracionItemEvaluados = consideracionItemEvaluados;
    }

    public Long getValorConsideracionItemEvaluados() {
        return valorConsideracionItemEvaluados;
    }

    public void setValorConsideracionItemEvaluados(Long valorConsideracionItemEvaluados) {
        this.valorConsideracionItemEvaluados = valorConsideracionItemEvaluados;
    }

    public Integer calculateRating(){
        Integer ratingTotal = 5;

        Integer totalConsideraciones = this.consideracionItemEvaluados.size();
        Long consideracionesChequeadas = this.consideracionItemEvaluados.stream().filter(line -> line.isCheckeado()).count();

        Long porcentajeDeConsideracionesChequeadas = (consideracionesChequeadas * 100) / totalConsideraciones;
        Integer porcentajeDeConsideracionesChequeadasConValorRedondeado = Math.round(porcentajeDeConsideracionesChequeadas);


        Integer estrellasCalculadas = (porcentajeDeConsideracionesChequeadasConValorRedondeado * ratingTotal) / 100;

        return Math.round(estrellasCalculadas);
    }

}
