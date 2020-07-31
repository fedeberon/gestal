package com.ideaas.services.service;

import com.ideaas.services.dao.RoleRepository;
import com.ideaas.services.domain.Rol;
import com.ideaas.services.service.interfaces.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    private RoleRepository dao;

    @Autowired
    public RolServiceImpl(RoleRepository dao) {
        this.dao = dao;
    }

    @Override
    public List<Rol> findAll() {
        return dao.findAll();
    }
}
