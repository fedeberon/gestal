package com.ideaas.services.service;

import com.ideaas.services.dao.colaborador.ColaboradorDaoPagination;
import com.ideaas.services.dao.user.UserDao;
import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.dao.colaborador.ColaboradorDao;
import com.ideaas.services.domain.User;
import com.ideaas.services.service.interfaces.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by federicoberon on 30/01/2020.
 */
@Service("colaboradorService")
public class ColaboradorServiceImpl implements ColaboradorService {

    private ColaboradorDao dao;
    private ColaboradorDaoPagination daoPagination;
    private UserDao userDao;


    @Autowired
    public ColaboradorServiceImpl(ColaboradorDao dao, ColaboradorDaoPagination daoPagination, UserDao userDao) {
        this.dao = dao;
        this.daoPagination = daoPagination;
        this.userDao = userDao;
    }

    @Override
    public List<Colaborador> findAll(){
        return dao.findAll();
    }

    @Override
    public Colaborador save(Colaborador colaborador) {

        switch (colaborador.getState()){
            case ACTIVE:
                colaborador.setEnabled(true);
                break;
            case INACTIVE:
                colaborador.setEnabled(false);
                break;
            default:
                colaborador.setEnabled(true);
        }
        return dao.save(colaborador);
    }

    @Override
    public Colaborador get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Colaborador> findAll(Integer pageSize, Integer pageNo, String id) {
        Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(id).descending());
        Page<Colaborador> colaborador = daoPagination.findAll(paging);

        return colaborador.getContent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Colaborador colaborador = dao.findByUsername(username);
        if (colaborador == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(colaborador.getUsername(), colaborador.getPassword(), new ArrayList<>());
    }

    @Override
    public UserDetails loadUserByUsernameApi(String username) throws UsernameNotFoundException {
        Colaborador colaborador = dao.findByUsername(username);
        String rol = String.valueOf(colaborador.getRoles().stream().findFirst().get().getName());
        if (rol.equals("COLABORADOR")) {
            throw new UsernameNotFoundException("User not found with role: " + rol);
        }

        if (colaborador == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(colaborador.getUsername(), colaborador.getPassword(), new ArrayList<>());
    }

    @Override
    public List<Colaborador> findColaboradorByName(String value) {
        return dao.findColaboradorByName(value);
    }

    @Override
    public void updateResetPassword(String token, String email) throws ColaboradorNotFoundException {
        Colaborador colaborador = dao.findByEmail(email);
        if (colaborador != null){
            colaborador.setResetPasswordToken(token);
            dao.save(colaborador);
        }else {
            throw new ColaboradorNotFoundException("No se pudo encontrar ningun colaborador con el email " + email);
        }
    }

    @Override
    public Colaborador get(String resetPasswordToken){
        return dao.findByResetPasswordToken(resetPasswordToken);
    }

    @Override
    public void updatePassword(Colaborador colaborador, String newPassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        colaborador.setPassword(encodedPassword);
        colaborador.setResetPasswordToken(null);

        dao.save(colaborador);
    }

    @Override
    public Colaborador validateEmail(String email){
        return dao.findByEmailIgnoreCase(email);
    }

    @Override
    public Colaborador validateUsername(String username){
        return dao.findByUsernameIgnoreCase(username);
    }

    @Override
    public Colaborador getUsername(String username) {
        return dao.findByUsername(username);
    }
}
