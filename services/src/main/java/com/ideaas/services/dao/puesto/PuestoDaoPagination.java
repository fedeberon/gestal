package com.ideaas.services.dao.puesto;

import com.ideaas.services.domain.Puesto;
import com.ideaas.services.domain.Rol;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Enzo on 28/2/2020.
 */
@Repository
public interface PuestoDaoPagination extends PagingAndSortingRepository<Puesto, Long> {
}
