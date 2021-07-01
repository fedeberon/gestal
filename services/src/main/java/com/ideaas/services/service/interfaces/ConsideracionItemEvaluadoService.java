package com.ideaas.services.service;

import com.ideaas.services.domain.ConsideracionItemEvaluado;

import java.util.List;

/**
 * Created by enzo on 17/4/2020.
 */
public interface ConsideracionItemEvaluadoService {
    List<ConsideracionItemEvaluado> findAll();
    List<ConsideracionItemEvaluado> findByItemEvaluadoId(Long id);
}
