package com.ideaas.services.dao.evaluacionDelColaborador;

import com.ideaas.services.domain.EvaluacionDelColaborador;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Enzo on 21/2/2020.
 */
public interface EvaluacionDelColaboradorPaginationDao extends PagingAndSortingRepository<EvaluacionDelColaborador, Long> {
}
