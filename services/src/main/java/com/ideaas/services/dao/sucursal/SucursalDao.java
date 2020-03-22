package com.ideaas.services.dao.sucursal;

import com.ideaas.services.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Benja on 22/3/2020.
 */
@Repository
public interface SucursalDao extends JpaRepository<Sucursal, Long> {
}
