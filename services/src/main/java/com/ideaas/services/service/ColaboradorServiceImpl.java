package com.ideaas.services.service;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.dao.ColaboradorDao;
import com.ideaas.services.service.interfaces.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by federicoberon on 30/01/2020.
 */
@Service
public class ColaboradorServiceImpl implements ColaboradorService {

    private ColaboradorDao dao;

    @Autowired
    public ColaboradorServiceImpl(ColaboradorDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Colaborador> findAll(){
        return dao.findAll();
    }

    @Override
    public Colaborador save(Colaborador colaborador) {
        return dao.save(colaborador);
    }

    @Override
    public Colaborador get(Long id) {
        return dao.findById(id).get();
    }
}
