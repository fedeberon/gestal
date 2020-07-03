package com.ideaas.services.domain.certificado;

import com.ideaas.services.domain.Colaborador;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CERTIFICADOS")
public class Certificado implements Serializable {

    @Id
    @Column(name = "CER_ID", unique=true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CER_TIPO")
    private CertificadoTipo tipoCertificado;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "CER_COL_ID", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Colaborador colaborador;

    @Column(name = "CER_FECHA_CARGA")
    private Date fechaDeCarga;

    @Transient
    public List<Imagen> imagenes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CertificadoTipo getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(CertificadoTipo tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Date getFechaDeCarga() {
        return fechaDeCarga;
    }

    public void setFechaDeCarga(Date fechaDeCarga) {
        this.fechaDeCarga = fechaDeCarga;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }
}
