package com.ideaas.services.dao.colaborador;

import com.ideaas.services.domain.Colaborador;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Enzo on 21/2/2020.
 */

@Repository
public interface ColaboradorDaoPagination extends PagingAndSortingRepository<Colaborador, Long> {
}
