package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.domain.Sucursal;

import java.util.List;

/**
 * Created by Enzo on 17/2/2020.
 */
public interface EvaluacionDelColaboradorService {

    List<EvaluacionDelColaborador> findAll();

    EvaluacionDelColaborador getById(Long id);

    List<EvaluacionDelColaborador> findByColaborador(Long id);

    EvaluacionDelColaborador get(Long id);
    EvaluacionDelColaborador save(EvaluacionDelColaborador evaluacionDelColaborador);
    Float calcularRatingPorConsideracion(EvaluacionDelColaborador evaluacionDelColaborador);
    long cantidadEvaluacionesMes();
    long cantidadEvaluacionesEntreRango();
    long cantidadEvaluacionesMayor();
    long cantidadEvaluacionesEnCero();
    List<String> scoreSucursal();
    List<EvaluacionDelColaborador> findAllPageable(int i, Integer page, String id);

    List<EvaluacionDelColaborador> findColaboradorByName(String name);

    EvaluacionDelColaborador update(EvaluacionDelColaborador evaluacionDelColaborador);
}
