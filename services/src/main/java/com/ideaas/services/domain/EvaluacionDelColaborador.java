package com.ideaas.services.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by federicoberon on 04/02/2020.
 */
@Entity
@Table(name = "EVALUACIONES_DE_COLABORADORES")
public class EvaluacionDelColaborador implements Serializable{


    @Id
    @Column(name = "EDC_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "EDC_COL_ID", nullable = false)
    private Colaborador colaborador;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "EDC_ROL_ID", nullable = false)
    private Rol rolEvaluado;

    /**
     * No es posible usarlo en level 25 de Android
    @Column(name = "EDC_FECHA")
    private LocalDateTime fecha = LocalDateTime.now();*/

    @Column(name = "EDC_FECHA_DE_CARGA")
    private Date fechaDeCarga;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evaluacionDelColaborador", cascade = CascadeType.PERSIST)
    private List<ItemEvaluado> itemEvaluados;

    private Float resultado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Rol getRolEvaluado() {
        return rolEvaluado;
    }

    public void setRolEvaluado(Rol rolEvaluado) {
        this.rolEvaluado = rolEvaluado;
    }

    public Date getFechaDeCarga() {
        return fechaDeCarga;
    }

    public void setFechaDeCarga(Date fechaDeCarga) {
        this.fechaDeCarga = fechaDeCarga;
    }

    public List<ItemEvaluado> getItemEvaluados() {
        return itemEvaluados;
    }

    public void setItemEvaluados(List<ItemEvaluado> itemEvaluados) {
        this.itemEvaluados = itemEvaluados;
    }

    public Float getResultado() {
        return resultado;
    }

    public void setResultado(Float resultado) {
        this.resultado = resultado;
    }
}
