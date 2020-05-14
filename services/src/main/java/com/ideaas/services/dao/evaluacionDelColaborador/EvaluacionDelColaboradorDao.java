package com.ideaas.services.dao.evaluacionDelColaborador;

import com.ideaas.services.domain.EvaluacionDelColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by federicoberon on 05/02/2020.
 */
public interface EvaluacionDelColaboradorDao extends JpaRepository<EvaluacionDelColaborador, Long> {
    @Query( value = "SELECT COUNT(*) FROM EVALUACIONES_DE_COLABORADORES WHERE MONTH(EDC_FECHA_DE_CARGA) = MONTH(CURRENT_DATE())", nativeQuery = true)
    long cantidadEvaluacionesMes();

    @Query( value = "SELECT COUNT(*) FROM EVALUACIONES_DE_COLABORADORES WHERE resultado BETWEEN 1 AND 20", nativeQuery = true)
    long cantidadEvaluacionesEntreRango();

    @Query( value = "SELECT COUNT(*) FROM EVALUACIONES_DE_COLABORADORES WHERE resultado > 20", nativeQuery = true)
    long cantidadEvaluacionesMayor();

    @Query( value = "SELECT COUNT(*) FROM EVALUACIONES_DE_COLABORADORES WHERE resultado = 0", nativeQuery = true)
    long cantidadEvaluacionesEnCero();



}