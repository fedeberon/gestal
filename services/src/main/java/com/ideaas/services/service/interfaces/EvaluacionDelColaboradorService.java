package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.EvaluacionDelColaborador;

import java.util.List;

/**
 * Created by Enzo on 17/2/2020.
 */
public interface EvaluacionDelColaboradorService {

    List<EvaluacionDelColaborador> findAllPageable(Integer pageSize, Integer pageNo, String id, String sortBy);

    List<EvaluacionDelColaborador> findAll();

    EvaluacionDelColaborador get(Long id);

    EvaluacionDelColaborador save(EvaluacionDelColaborador evaluacionDelColaborador);

    EvaluacionDelColaborador calcularRatingPorConsideracion();

    long cantidadMes();

    List<EvaluacionDelColaborador> findAllPageable(int i, Integer page, String id);
}
