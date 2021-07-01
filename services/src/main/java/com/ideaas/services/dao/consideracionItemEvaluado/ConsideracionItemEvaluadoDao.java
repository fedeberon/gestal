package com.ideaas.services.dao.consideracionItemEvaluado;

import com.ideaas.services.domain.ConsideracionItemEvaluado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by enzo on 17/4/2020.
 */
@Repository
public interface ConsideracionItemEvaluadoDao extends JpaRepository<ConsideracionItemEvaluado, Long> {
    List<ConsideracionItemEvaluado> findByItemEvaluado_Id(Long id);
}
