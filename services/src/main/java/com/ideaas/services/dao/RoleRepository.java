package com.ideaas.services.dao;

import com.ideaas.services.domain.Role;
import com.ideaas.services.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
