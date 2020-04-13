package com.ideaas.services.domain;

import javax.persistence.*;

/**
 * Created by enzo on 13/4/2020.
 */
@Entity
@Table(name = "CONSIDERACION_ITEM_EVALUADO")
public class ConsideracionItemEvaluado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CIE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CON_ID", nullable = false)
    private Consideracion consideracion;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IEV_ID", nullable = false)
    private ItemEvaluado itemEvaluado;

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

    public ItemEvaluado getItemEvaluado() {
        return itemEvaluado;
    }

    public void setItemEvaluado(ItemEvaluado itemEvaluado) {
        this.itemEvaluado = itemEvaluado;
    }

    public boolean isCheckeado() {
        return checkeado;
    }

    public void setCheckeado(boolean checkeado) {
        this.checkeado = checkeado;
    }
}
