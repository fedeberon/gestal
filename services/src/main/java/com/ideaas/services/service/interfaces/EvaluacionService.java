package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.domain.Rol;

import java.util.List;

/**
 * Created by federicoberon on 04/02/2020.
 */
public interface EvaluacionService {
    Evaluacion getByRol(Rol rol);

    Evaluacion save(Evaluacion evaluacion);

    List<Evaluacion> findAllPageable(Integer pageSize, Integer pageNo, String sortBy);

    List<Evaluacion> findAll();

    Evaluacion getById(Long id);

    EvaluacionDelColaborador get(Long id);

    Integer findOneMonth();
}
