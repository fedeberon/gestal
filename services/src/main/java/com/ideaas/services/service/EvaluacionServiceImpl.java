package com.ideaas.services.service;

import com.ideaas.services.dao.EvaluacionDao;
import com.ideaas.services.dao.EvaluacionDelColaboradorDao;
import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.service.interfaces.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by federicoberon on 04/02/2020.
 */
@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    private EvaluacionDao dao;

    private EvaluacionDelColaboradorDao evaluacionDelColaboradorDao;

    @Autowired
    public EvaluacionServiceImpl(EvaluacionDao dao) {
        this.dao = dao;
    }

    @Override
    public Evaluacion getByRol(String rol) {
        return dao.getActiveByRol(rol);
    }

    @Override
    public Evaluacion save(Evaluacion evaluacion){
        return dao.save(evaluacion);
    }

    @Override
    public EvaluacionDelColaborador save(EvaluacionDelColaborador evaluacionDelColaborador) {
        return evaluacionDelColaboradorDao.save(evaluacionDelColaborador);
    }

    @Override
    public List<Evaluacion> findAll() {
        return dao.findAll();
    }


}
