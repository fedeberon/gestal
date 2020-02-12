package com.ideaas.web.controller;

import com.ideaas.services.domain.User;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
         model.addAttribute("usuarios", usuarioService.findAll(size, page, "id"));

        return "usuario/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(User user) {
        usuarioService.save(user);

        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        User usuario= usuarioService.getById(id);
        model.addAttribute("usuario", usuario);

        return "usuario/update";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("usuario") User user) {

        return "usuario/create";
    }
}
