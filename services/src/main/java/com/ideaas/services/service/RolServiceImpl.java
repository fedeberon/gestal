package com.ideaas.services.service;

import com.ideaas.services.dao.rol.RolDao;
import com.ideaas.services.dao.rol.RolDaoPagination;
import com.ideaas.services.domain.Rol;
import com.ideaas.services.service.interfaces.RolService;
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
public class RolServiceImpl implements RolService {

    private RolDao dao;
    private RolDaoPagination daoPagination;

    @Autowired
    public RolServiceImpl(RolDao dao, RolDaoPagination daoPagination) {
        this.dao = dao;
        this.daoPagination = daoPagination;
    }

    @Override
    public List<Rol> findAll(){
        return dao.findAll();
    }

    @Override
    public Rol save(Rol rol) {
        return dao.save(rol);
    }

    @Override
    public Rol get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Rol> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Rol> roles = daoPagination.findAll(paging);

        return roles.getContent();
    }


}
