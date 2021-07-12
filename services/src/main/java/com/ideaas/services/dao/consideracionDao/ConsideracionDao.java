package com.ideaas.services.dao.consideracionDao;

import com.ideaas.services.domain.Consideracion;
import com.ideaas.services.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsideracionDao extends JpaRepository<Consideracion, Long> {
}
