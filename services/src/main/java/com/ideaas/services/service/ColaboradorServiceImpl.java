package com.ideaas.services.service;

import com.ideaas.services.dao.colaborador.ColaboradorDaoPagination;
import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.dao.colaborador.ColaboradorDao;
import com.ideaas.services.service.interfaces.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by federicoberon on 30/01/2020.
 */
@Service
public class ColaboradorServiceImpl implements ColaboradorService {

    private ColaboradorDao dao;
    private ColaboradorDaoPagination daoPagination;

    @Autowired
    public ColaboradorServiceImpl(ColaboradorDao dao, ColaboradorDaoPagination daoPagination) {
        this.dao = dao;
        this.daoPagination = daoPagination;
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

    @Override
    public List<Colaborador> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Colaborador> colaborador = daoPagination.findAll(paging);

        return colaborador.getContent();
    }
}
