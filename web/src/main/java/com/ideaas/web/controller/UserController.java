package com.ideaas.web.controller;

import com.ideaas.services.dao.RoleRepository;
import com.ideaas.services.domain.Role;
import com.ideaas.services.domain.Sucursal;
import com.ideaas.services.domain.User;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Enzo on 8/2/2020.
 */
@Controller
@RequestMapping("usuario")
public class UserController {

    private UsuarioService usuarioService;
    private RoleRepository roleDao;


    @Autowired
    public UserController(UsuarioService usuarioService, RoleRepository roleDao) {
        this.usuarioService = usuarioService;
        this.roleDao = roleDao;
    }

    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model){
        List<User> usuarios = usuarioService.findAll(size, page,"id");
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("page" , page);

        return "usuario/list";
    }

    @RequestMapping(value = "save")
    public String save(@Valid @ModelAttribute("usuario") User user, BindingResult result) {
        if (result.hasErrors()){
            return "usuario/create";
        }
        else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String pass = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(pass);
            usuarioService.save(user);

            return "redirect:list";
        }
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        User usuario= usuarioService.getById(id);
        model.addAttribute("usuario", usuario);

        return "usuario/update";
    }

    @RequestMapping("show")
    public String show(@RequestParam Long id, Model model) {
        User usuario= usuarioService.getById(id);
        model.addAttribute("usuario", usuario);

        return "usuario/show";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("usuario") User user) {

        return "usuario/create";
    }

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return roleDao.findAll();
    }


    @RequestMapping("/register")
    public String register(Model model){
        return "usuario/signin";
    }


}
