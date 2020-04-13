package com.ideaas.services.dao.evaluacionDelColaborador;

import com.ideaas.services.domain.EvaluacionDelColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by federicoberon on 05/02/2020.
 */
public interface EvaluacionDelColaboradorDao extends JpaRepository<EvaluacionDelColaborador, Long> {
    @Query( value = "SELECT COUNT(*) FROM EVALUACIONES_DE_COLABORADORES WHERE MONTH(EDC_FECHA_DE_CARGA) = MONTH(CURRENT_DATE())", nativeQuery = true)
    long cantidadMes();
}
