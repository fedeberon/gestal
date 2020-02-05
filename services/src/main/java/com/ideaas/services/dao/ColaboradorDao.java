package com.ideaas.services.dao;

import com.ideaas.services.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by federicoberon on 30/01/2020.
 */
@Repository
public interface ColaboradorDao extends JpaRepository<Colaborador, Long> {



}
