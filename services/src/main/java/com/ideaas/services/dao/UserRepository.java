package com.ideaas.services.dao;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<Colaborador, Long> {

    @Query("SELECT u FROM Colaborador u WHERE u.username = :username")
    public Colaborador getColaboradorByUsername(@Param("username") String username);
}
