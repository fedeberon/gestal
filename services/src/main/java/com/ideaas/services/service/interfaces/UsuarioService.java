package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService extends UserDetailsService {

    User get(String username);
    User getById(Long id);
    User save(User user);
    List<User> findAll(Integer pageSize, Integer pageNo, String sortBy);


}
