package com.ideaas.services.dao.evaluacionDelColaborador;

import com.ideaas.services.domain.EvaluacionDelColaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Enzo on 21/2/2020.
 */
public interface EvaluacionDelColaboradorPaginationDao extends PagingAndSortingRepository<EvaluacionDelColaborador, Long> {

    Page<EvaluacionDelColaborador> findByColaborador_LastNameContainingOrderByIdDesc(@Param("LastName") String LastName, Pageable pageable);

}
