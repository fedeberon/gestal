package com.ideaas.services.domain;

import javax.persistence.*;

/**
 * Created by enzo on 13/4/2020.
 */
@Entity
@Table(name = "CONSIDERACION_ITEM_EVALUADO")
public class ConsideracionItemEvaluado {

    @Id
    @Column(name = "CIE_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Consideracion consideracion;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
//    @JoinColumn(name = "IEV_ID", nullable = false)
//    private ItemEvaluado itemEvaluado;

    private boolean checkeado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consideracion getConsideracion() {
        return consideracion;
    }

    public void setConsideracion(Consideracion consideracion) {
        this.consideracion = consideracion;
    }
//
//    public ItemEvaluado getItemEvaluado() {
//        return itemEvaluado;
//    }
//
//    public void setItemEvaluado(ItemEvaluado itemEvaluado) {
//        this.itemEvaluado = itemEvaluado;
//    }

    public boolean isCheckeado() {
        return checkeado;
    }

    public void setCheckeado(boolean checkeado) {
        this.checkeado = checkeado;
    }

}
