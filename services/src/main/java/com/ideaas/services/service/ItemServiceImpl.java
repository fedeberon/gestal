package com.ideaas.services.service;

import com.ideaas.services.dao.ItemDao;
import com.ideaas.services.domain.Item;
import com.ideaas.services.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo on 10/2/2020.
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao dao;

    @Override
    public List<Item> findAll() {
        return dao.findAll();
    }

    @Override
    public Item save(Item item) {
        return dao.save(item);
    }
}
