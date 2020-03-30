package com.ideaas.services.service;

import com.ideaas.services.dao.ItemDao;
import com.ideaas.services.dao.consideracionDao.ConsideracionDao;
import com.ideaas.services.domain.Consideracion;
import com.ideaas.services.domain.Item;
import com.ideaas.services.service.interfaces.ConsideracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsideracionServiceImpl implements ConsideracionService {

    @Autowired
    private ConsideracionDao dao;

    @Override
    public List<Consideracion> findAll() {
        return dao.findAll();
    }

    @Override
    public Consideracion save(Consideracion consideracion) {
        return dao.save(consideracion);
    }

    @Override
    public Consideracion getById(Long id) {
        return dao.findById(id).get();
    }
}
