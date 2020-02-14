package com.ideaas.services.service;

import com.ideaas.services.dao.EvaluacionDelColaboradorDao;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo on 14/2/2020.
 */
@Service
public class EvaluacionDelColaboradorImpl implements EvaluacionDelColaboradorService{

    private EvaluacionDelColaboradorDao dao;


    @Override
    public List<EvaluacionDelColaborador> findAll() {
        return dao.findAll();
    }
}
