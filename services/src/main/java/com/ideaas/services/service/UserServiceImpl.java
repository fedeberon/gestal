package com.ideaas.services.service;

import com.ideaas.services.dao.RoleRepository;
import com.ideaas.services.domain.User;
import com.ideaas.services.dao.user.UserDao;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Primary
@Service("usuarioService")
public class UserServiceImpl implements UsuarioService {

    private UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao, RoleRepository roleDao) {
        this.dao = dao;
    }

    @Override
    public User get(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public User getById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public User save(User user) {
        user.setEnabled(true);
        return dao.save(user);
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }

    @Override
    public List<User> findAll(Integer pageSize, Integer pageNo, String id) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(id).descending());
        Page<User> usuarios = dao.findAll(paging);

        return usuarios.getContent();
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

}
