package com.ideaas.services.dao.rol;

import com.ideaas.services.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Enzo on 10/2/2020.
 */
@Repository
public interface RolDao extends JpaRepository<Rol, Long> {
}
