package com.ideaas.services.service;

import com.ideaas.services.bean.State;
import com.ideaas.services.dao.evaluacion.EvaluacionDao;
import com.ideaas.services.dao.evaluacion.EvaluacionDaoPagination;
import com.ideaas.services.dao.evaluacionDelColaborador.EvaluacionDelColaboradorDao;
import com.ideaas.services.domain.*;
import com.ideaas.services.service.interfaces.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by federicoberon on 04/02/2020.
 */
@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    private EvaluacionDao dao;
    private EvaluacionDaoPagination daoPageable;
    private EvaluacionDelColaboradorDao evaluacionDelColaboradorDao;

    @Autowired
    public EvaluacionServiceImpl(EvaluacionDao dao, EvaluacionDelColaboradorDao evaluacionDelColaboradorDao, EvaluacionDaoPagination evaluacionDaoPagination) {
        this.daoPageable = evaluacionDaoPagination;
        this.dao = dao;
        this.evaluacionDelColaboradorDao = evaluacionDelColaboradorDao;
    }

    @Override
    public Evaluacion getByRol(Rol rol) {
        return dao.getActiveByRol(rol);
    }

    @Override
    public Evaluacion save(Evaluacion evaluacion){
        List<Evaluacion> evaluaciones = dao.findAll();
        evaluaciones.forEach(evaluacionRol ->{
            if (evaluacion.getRol().getId().equals(evaluacionRol.getRol().getId()) ){
                evaluacionRol.setState(State.INACTIVE);
            }
        });
        evaluacion.setState(State.ACTIVE);

        return dao.save(evaluacion);
    }


    @Override
    public EvaluacionDelColaborador get(Long id) {
        return evaluacionDelColaboradorDao.findById(id).get();
    }

    @Override
    public List<Evaluacion> findAllPageable(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Evaluacion> evaluacion = daoPageable.findAll(paging);

        return evaluacion.getContent();
    }

    @Override
    public List<Evaluacion> findAll() {
        Iterable<Evaluacion> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Evaluacion getById(Long id) {

        return dao.findById(id).get();
    }
    @Override
    public Integer findOneMonth(){
        dao.findOneMonth();
        return null;
    }

}
