package com.ideaas.services.service;

import com.ideaas.services.dao.evaluacionDelColaborador.EvaluacionDelColaboradorDao;
import com.ideaas.services.dao.evaluacionDelColaborador.EvaluacionDelColaboradorPaginationDao;
import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Enzo on 17/2/2020.
 */

@Service
public class EvaluacionDelColaboradorImpl implements EvaluacionDelColaboradorService{

    private EvaluacionDelColaboradorDao dao;
    private EvaluacionDelColaboradorPaginationDao daoPageable;

    @Autowired
    public EvaluacionDelColaboradorImpl(EvaluacionDelColaboradorDao dao, EvaluacionDelColaboradorPaginationDao paginationDao) {
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
    public EvaluacionDelColaborador get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public EvaluacionDelColaborador save(EvaluacionDelColaborador evaluacionDelColaborador) {
        evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> itemEvaluado.setEvaluacionDelColaborador(evaluacionDelColaborador));
        evaluacionDelColaborador.setFechaDeCarga(new Date());
        return dao.save(evaluacionDelColaborador);
    }
}
