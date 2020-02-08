package com.ideaas.web.controller;

import com.ideaas.services.domain.User;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Enzo on 8/2/2020.
 */
@Controller
@RequestMapping("usuario")
public class UserController {

    private UsuarioService usuarioService;

    @Autowired
    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping("list")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        List<User> usuarios= usuarioService.findAll(size, page,"id");
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("page" , page);

        return "usuario/list";
    }
}
