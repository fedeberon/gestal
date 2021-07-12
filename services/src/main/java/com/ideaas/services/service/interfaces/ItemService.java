package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Item;
import com.ideaas.services.domain.ItemEvaluado;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Enzo on 10/2/2020.
 */
public interface ItemService {
    List<Item> findAll();
    List<Item> findByEvaluacionId(Long id);
    Item save(Item item);
    Item getById(Long id);
    void deleteAll(List<Item> indicadores);
}
