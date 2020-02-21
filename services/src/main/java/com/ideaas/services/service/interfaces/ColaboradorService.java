package com.ideaas.services.service.interfaces;


import com.ideaas.services.domain.Colaborador;

import java.util.List;

/**
 * Created by federicoberon on 30/01/2020.
 */
public interface ColaboradorService {
    List<Colaborador> findAll();
    Colaborador save(Colaborador colaborador);
    Colaborador get(Long id);
    List<Colaborador> findAllPageable(Integer pageSize, Integer pageNo, String sortBy);


}
