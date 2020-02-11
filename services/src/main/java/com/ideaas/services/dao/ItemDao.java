package com.ideaas.services.dao;

import com.ideaas.services.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Enzo on 10/2/2020.
 */
@Repository
public interface ItemDao extends JpaRepository<Item, Long> {
}
