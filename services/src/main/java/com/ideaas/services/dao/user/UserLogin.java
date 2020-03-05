package com.ideaas.services.dao.user;

import com.ideaas.services.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Enzo on 5/3/2020.
 */
public interface UserLogin extends JpaRepository <User, Long> {

    User findByUsername(String username);
}
