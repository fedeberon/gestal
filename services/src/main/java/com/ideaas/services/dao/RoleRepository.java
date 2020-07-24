package com.ideaas.services.dao;

import com.ideaas.services.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Rol, Long> {
}
