package com.ideaas.services.dao.colaborador;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by federicoberon on 30/01/2020.
 */
@Repository
public interface ColaboradorDao extends JpaRepository<Colaborador, Long> {

    @Query("SELECT c FROM Colaborador c WHERE c.name LIKE %?1%"
            + "OR c.puesto.name LIKE %?1%"
            + "OR c.sucursal.name LIKE %?1%"
            + "OR c.email LIKE %?1%"
    )
    List<Colaborador> findColaboradorByName(String value);

    Colaborador findByUsername(String username);

}
