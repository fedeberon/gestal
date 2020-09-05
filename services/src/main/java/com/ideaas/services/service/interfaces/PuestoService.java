package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Puesto;

import java.util.List;

public interface PuestoService {
    List<Puesto> findAll();

    Puesto save(Puesto puesto);

    Puesto get(Long id);

    List<Puesto> findAll(Integer pageSize, Integer pageNo, String sortBy);
}
