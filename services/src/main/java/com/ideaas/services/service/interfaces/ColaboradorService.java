package com.ideaas.services.service.interfaces;


import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.service.ColaboradorNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by federicoberon on 30/01/2020.
 */
public interface ColaboradorService extends UserDetailsService {
    List<Colaborador> findAll();
    Colaborador save(Colaborador colaborador);
    Colaborador get(Long id);
    List<Colaborador> findAll(Integer pageSize, Integer pageNo, String sortBy);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    List<Colaborador> findColaboradorByName(String value);

    void updateResetPassword(String token, String email) throws ColaboradorNotFoundException;

    Colaborador get(String resetPasswordToken);

    void updatePassword(Colaborador colaborador, String newPassword);

    Colaborador validateEmail(String email);

    Colaborador validateUsername(String username);

    Colaborador getUsername(String username);
}
