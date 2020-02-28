package com.ideaas.services.dao.rol;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.Rol;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Enzo on 28/2/2020.
 */
@Repository
public interface RolDaoPagination extends PagingAndSortingRepository<Rol, Long> {
}
