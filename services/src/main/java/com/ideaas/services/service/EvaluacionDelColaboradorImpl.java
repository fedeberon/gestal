package com.ideaas.services.service;

import com.ideaas.services.dao.EvaluacionDelColaboradorDao;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo on 17/2/2020.
 */

@Service
public class EvaluacionDelColaboradorImpl implements EvaluacionDelColaboradorService{

    private EvaluacionDelColaboradorDao dao;

    @Autowired
    public EvaluacionDelColaboradorImpl(EvaluacionDelColaboradorDao dao) {
        this.dao = dao;
    }

    @Override
    public List<EvaluacionDelColaborador> findAll() {
        return dao.findAll();
    }
}
