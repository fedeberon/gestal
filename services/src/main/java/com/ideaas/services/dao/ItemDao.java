package com.ideaas.services.dao;

import com.ideaas.services.domain.Item;
import com.ideaas.services.domain.ItemEvaluado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Enzo on 10/2/2020.
 */
@Repository
public interface ItemDao extends JpaRepository<Item, Long> {
    List<Item> findByEvaluacion_Id(Long id);

}
