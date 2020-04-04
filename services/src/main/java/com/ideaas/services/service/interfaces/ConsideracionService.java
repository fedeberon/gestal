package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Consideracion;

import java.util.List;

public interface ConsideracionService {

    List<Consideracion> findAll();

    Consideracion save(Consideracion consideracion);

    Consideracion getById(Long id);
}
