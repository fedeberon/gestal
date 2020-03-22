package com.ideaas.services.service;

import com.ideaas.services.dao.colaborador.ColaboradorDao;
import com.ideaas.services.dao.colaborador.ColaboradorDaoPagination;
import com.ideaas.services.dao.sucursal.SucursalDao;
import com.ideaas.services.dao.sucursal.SucursalDaoPagination;
import com.ideaas.services.dao.user.UserDao;
import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Benja on 22/3/2020.
 */
@Service("sucursalService")
public class SucursalServiceImpl {
    private SucursalDao dao;
    private SucursalDaoPagination daoPagination;
    private UserDao userDao;


    @Autowired
    public SucursalServiceImpl(SucursalDao dao, SucursalDaoPagination daoPagination, UserDao userDao) {
        this.dao = dao;
        this.daoPagination = daoPagination;
        this.userDao = userDao;
    }

    @Override
    public List<Sucursal> findAll(){
        return dao.findAll();
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return dao.save(sucursal);
    }

    @Override
    public Sucursal get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Sucursal> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Sucursal> sucursal = daoPagination.findAll(paging);

        return sucursal.getContent();
    }


}
