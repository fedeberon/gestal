package com.ideaas.services.dao.itemEvaluado;

import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.ItemEvaluado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemEvaluadoDao extends JpaRepository<ItemEvaluado, Long> {
    List<ItemEvaluado> findByEvaluacionDelColaborador_Id(Long id);
    List<ItemEvaluado> findByItem_Evaluacion_Id(Long id);
}
