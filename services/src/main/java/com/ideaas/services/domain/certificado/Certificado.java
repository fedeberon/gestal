package com.ideaas.services.domain.certificado;

import com.ideaas.services.domain.Colaborador;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
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

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "CER_FECHA_INICIO")
    private LocalDate fechaInicio;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "CER_FECHA_FIN")
    private LocalDate fechaFinalizacion;

    @Transient
    public List<Imagen> imagenes = new ArrayList<>();

    @Column(name = "CER_AUSENTISMO")
    private Integer ausentismo;

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

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Integer getAusentismo() {
        return ausentismo;
    }

    public void setAusentismo(Integer ausentismo) {
        this.ausentismo = ausentismo;
    }
}
