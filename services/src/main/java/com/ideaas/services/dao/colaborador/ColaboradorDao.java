package com.ideaas.services.dao.colaborador;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by federicoberon on 30/01/2020.
 */
@Repository
public interface ColaboradorDao extends JpaRepository<Colaborador, Long> {

    Colaborador findByUsername(String username);


}
