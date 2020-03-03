package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Rol;

import java.util.List;

public interface RolService {
    List<Rol> findAll();

    Rol save(Rol rol);

    Rol get(Long id);

    List<Rol> findAll(Integer pageSize, Integer pageNo, String sortBy);
}
