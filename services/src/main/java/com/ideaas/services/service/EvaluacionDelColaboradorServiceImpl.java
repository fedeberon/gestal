package com.ideaas.services.service;

import com.ideaas.services.dao.evaluacionDelColaborador.EvaluacionDelColaboradorDao;
import com.ideaas.services.dao.evaluacionDelColaborador.EvaluacionDelColaboradorPaginationDao;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Enzo on 17/2/2020.
 */

@Service
public class EvaluacionDelColaboradorServiceImpl implements EvaluacionDelColaboradorService{

    private EvaluacionDelColaboradorDao dao;
    private EvaluacionDelColaboradorPaginationDao daoPageable;

    @Autowired
    public EvaluacionDelColaboradorServiceImpl(EvaluacionDelColaboradorDao dao, EvaluacionDelColaboradorPaginationDao paginationDao) {
        this.dao = dao;
        this.daoPageable = paginationDao;
    }

    @Override
    public List<EvaluacionDelColaborador> findAllPageable(Integer pageSize, Integer pageNo, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<EvaluacionDelColaborador> evaluacionDelColaborador = daoPageable.findAll(paging);

        return evaluacionDelColaborador.getContent();
    }

    @Override
    public List<EvaluacionDelColaborador> findAll(){
        return dao.findAll();
    }

    @Override
    public EvaluacionDelColaborador get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public EvaluacionDelColaborador save(EvaluacionDelColaborador evaluacionDelColaborador) {
        evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> itemEvaluado.setEvaluacionDelColaborador(evaluacionDelColaborador));
        evaluacionDelColaborador.setFechaDeCarga(new Date());
        return dao.save(evaluacionDelColaborador);
    }

    @Override
    public EvaluacionDelColaborador calcularScore(){
        List<EvaluacionDelColaborador> evaluaciones = dao.findAll();

        evaluaciones.forEach(evaluacion ->{
            AtomicReference<Float> resultado = new AtomicReference<>(Float.valueOf(0));

            evaluacion.getItemEvaluados().forEach(itemEvaluado -> {
                //Si el checkbox que invalida la evaluacion o el rating del item es 0, el score de la evaluacion es 0
                if(itemEvaluado.getItem().isInvalidaEvaluacion() == true || itemEvaluado.getItem().getScore() == 0) {
                    evaluacion.setResultado(Float.valueOf(0));

                }else {
                    Float resultadoPorItem = (Float.valueOf(itemEvaluado.getRating()) * Float.valueOf(itemEvaluado.getItem().getScore()));
                    resultado.set(resultado.get() + resultadoPorItem);
                }
            });
            evaluacion.setResultado(resultado.get());
        });
        return null;
    }
}
