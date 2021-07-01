package com.ideaas.services.service;

import com.ideaas.services.dao.consideracionItemEvaluado.ConsideracionItemEvaluadoDao;
import com.ideaas.services.domain.ConsideracionItemEvaluado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enzo on 17/4/2020.
 */
@Service
public class ConsideracionItemEvaluadoServiceImpl implements com.ideaas.services.service.ConsideracionItemEvaluadoService {

    private ConsideracionItemEvaluadoDao dao;

    @Autowired
    public ConsideracionItemEvaluadoServiceImpl(ConsideracionItemEvaluadoDao dao) {
        this.dao = dao;
    }

    @Override
    public List<ConsideracionItemEvaluado> findAll(){
        return dao.findAll();
    }

    @Override
    public List<ConsideracionItemEvaluado> findByItemEvaluadoId(Long id){
        return dao.findByItemEvaluado_Id(id);
    }
}
