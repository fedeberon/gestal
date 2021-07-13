package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.ItemEvaluado;

import java.util.List;

public interface ItemEvaluadoService {

    List<ItemEvaluado> findAll();

    ItemEvaluado get(Long id);

    List<ItemEvaluado> findByEvaluacionDelColaboradorId(Long id);

    void deleteAll(List<ItemEvaluado> itemEvaluados);

    List<ItemEvaluado> findByEvaluacionId(Long id);
}
