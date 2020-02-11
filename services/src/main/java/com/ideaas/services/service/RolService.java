package com.ideaas.services.service;

import com.ideaas.services.domain.Rol;
import com.ideaas.services.service.interfaces.RolServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Enzo on 10/2/2020.
 */
public interface RolService  {
    List<Rol> findAll();
}
