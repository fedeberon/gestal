package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by federicoberon on 04/02/2020.
 */
public interface EvaluacionService {
    Evaluacion getByRol(String rol);

    Evaluacion save(Evaluacion evaluacion);

    EvaluacionDelColaborador save(EvaluacionDelColaborador evaluacionDelColaborador);

    List<Evaluacion> findAllPageable(Integer pageSize, Integer pageNo, String sortBy);

    List<Evaluacion> findAll();

    Evaluacion getById(Long id);

    EvaluacionDelColaborador get(Long id);


}
