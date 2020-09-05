package com.ideaas.services.service;

import com.ideaas.services.dao.puesto.PuestoDao;
import com.ideaas.services.dao.puesto.PuestoDaoPagination;
import com.ideaas.services.domain.Puesto;
import com.ideaas.services.service.interfaces.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo on 10/2/2020.
 */
@Service
public class PuestoServiceImpl implements PuestoService {

    private PuestoDao dao;
    private PuestoDaoPagination daoPagination;

    @Autowired
    public PuestoServiceImpl(PuestoDao dao, PuestoDaoPagination daoPagination) {
        this.dao = dao;
        this.daoPagination = daoPagination;
    }

    @Override
    public List<Puesto> findAll(){
        return dao.findAll();
    }

    @Override
    public Puesto save(Puesto rol) {
        return dao.save(rol);
    }

    @Override
    public Puesto get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Puesto> findAll(Integer pageSize, Integer pageNo, String id) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(id).descending());
        Page<Puesto> roles = daoPagination.findAll(paging);

        return roles.getContent();
    }


}
