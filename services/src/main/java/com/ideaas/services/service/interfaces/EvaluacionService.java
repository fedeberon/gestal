package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.domain.Puesto;

import java.util.List;

/**
 * Created by federicoberon on 04/02/2020.
 */
public interface EvaluacionService {
    List<Evaluacion> findAllPageable(Integer pageSize, Integer pageNo, String sortBy);
    List<Evaluacion> findAll();
    Evaluacion getByPuesto(Puesto puesto);
    Evaluacion save(Evaluacion evaluacion);
    Evaluacion getById(Long id);
    Evaluacion desactivarEvaluacion(Evaluacion evaluacion);
    Evaluacion activarEvaluacion(Evaluacion evaluacion);
    EvaluacionDelColaborador get(Long id);

    void delete(Evaluacion byId);
}
