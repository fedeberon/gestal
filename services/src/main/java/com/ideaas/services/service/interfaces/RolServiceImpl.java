package com.ideaas.services.service.interfaces;

import com.ideaas.services.dao.RolDao;
import com.ideaas.services.domain.Rol;
import com.ideaas.services.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo on 10/2/2020.
 */
@Service
public class RolServiceImpl implements RolService{

    private RolDao dao;

    @Autowired
    public RolServiceImpl(RolDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Rol> findAll(){
        return dao.findAll();
    }
}
