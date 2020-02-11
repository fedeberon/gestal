package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Item;

import java.util.List;

/**
 * Created by Enzo on 10/2/2020.
 */
public interface ItemService {
    List<Item> findAll();
    Item save(Item item);
}
