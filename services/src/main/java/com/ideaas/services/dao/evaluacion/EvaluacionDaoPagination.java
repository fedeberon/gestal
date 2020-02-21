package com.ideaas.services.dao.evaluacion;

import com.ideaas.services.domain.Evaluacion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Enzo on 21/2/2020.
 */
@Repository
public interface EvaluacionDaoPagination extends PagingAndSortingRepository<Evaluacion, Long> {
}
