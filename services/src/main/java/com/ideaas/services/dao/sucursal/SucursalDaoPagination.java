package com.ideaas.services.dao.sucursal;

import com.ideaas.services.domain.Sucursal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Benja on 22/3/2020.
 */
@Repository
public interface SucursalDaoPagination extends PagingAndSortingRepository<Sucursal, Long> {
}

