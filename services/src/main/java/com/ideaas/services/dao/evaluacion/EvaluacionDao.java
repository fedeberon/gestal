package com.ideaas.services.dao.evaluacion;

import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by federicoberon on 04/02/2020.
 */
@Repository
public interface EvaluacionDao extends JpaRepository<Evaluacion, Long> {

    @Query("FROM Evaluacion WHERE rol = ?1 and state = 'ACTIVE'")
    Evaluacion getActiveByRol(Rol rol);
}
