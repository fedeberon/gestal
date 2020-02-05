package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;

/**
 * Created by federicoberon on 04/02/2020.
 */
public interface EvaluacionService {
    Evaluacion getByRol(String rol);

    EvaluacionDelColaborador save(EvaluacionDelColaborador evaluacionDelColaborador);
}
