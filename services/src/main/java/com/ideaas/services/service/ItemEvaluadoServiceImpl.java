package com.ideaas.services.service;

import com.ideaas.services.dao.itemEvaluado.ItemEvaluadoDao;
import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.ItemEvaluado;
import com.ideaas.services.service.interfaces.ItemEvaluadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemEvaluadoServiceImpl implements ItemEvaluadoService {

    private ItemEvaluadoDao dao;

    @Autowired
    public ItemEvaluadoServiceImpl(ItemEvaluadoDao dao) {
        this.dao = dao;
    }


    @Override
    public List<ItemEvaluado> findAll() {
        Iterable<ItemEvaluado> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public ItemEvaluado get(Long id) {
        return dao.getOne(id);
    }

    @Override
    public List<ItemEvaluado> findByEvaluacionDelColaboradorId(Long id){
        return dao.findByEvaluacionDelColaborador_Id(id);
    }

    @Override
    public void deleteAll(List<ItemEvaluado> itemEvaluados){
        dao.deleteAll(itemEvaluados);
    }

}
