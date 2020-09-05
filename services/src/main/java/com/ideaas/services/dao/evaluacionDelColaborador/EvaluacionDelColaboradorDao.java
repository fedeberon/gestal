package com.ideaas.services.dao.evaluacionDelColaborador;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by federicoberon on 05/02/2020.
 */
@Repository
public interface EvaluacionDelColaboradorDao extends JpaRepository<EvaluacionDelColaborador, Long> {
    @Query( value = "SELECT COUNT(*) FROM EVALUACIONES_DE_COLABORADORES WHERE MONTH(EDC_FECHA_DE_CARGA) = MONTH(CURRENT_DATE())", nativeQuery = true)
    long cantidadEvaluacionesMes();

    @Query( value = "SELECT COUNT(*) FROM EVALUACIONES_DE_COLABORADORES WHERE resultado BETWEEN 1 AND 20", nativeQuery = true)
    long cantidadEvaluacionesEntreRango();

    @Query( value = "SELECT COUNT(*) FROM EVALUACIONES_DE_COLABORADORES WHERE resultado > 20", nativeQuery = true)
    long cantidadEvaluacionesMayor();

    @Query( value = "SELECT COUNT(*) FROM EVALUACIONES_DE_COLABORADORES WHERE resultado = 0", nativeQuery = true)
    long cantidadEvaluacionesEnCero();

    @Query( value = "SELECT SUM(EVALUACIONES_DE_COLABORADORES.resultado) AS RESULTADO FROM EVALUACIONES_DE_COLABORADORES JOIN COLABORADORES ON EVALUACIONES_DE_COLABORADORES.EDC_COL_ID = COLABORADORES.COL_ID JOIN SUCURSALES ON COLABORADORES.COL_SUC_ID = SUCURSALES.SUC_ID GROUP BY SUC_NAME;", nativeQuery = true)
    List<String> scoreSucursal();

    @Query("SELECT c FROM EvaluacionDelColaborador c WHERE c.colaborador.name LIKE %?1%"
            + "OR c.id LIKE %?1%"
            + "OR c.colaborador.sucursal.name LIKE %?1%"
            + "OR c.fechaDeCarga LIKE %?1%"
            + "OR c.rolEvaluado.name LIKE %?1%"
    )
    List<EvaluacionDelColaborador> findEvaluacionDelColaboradorByName(String name);

}