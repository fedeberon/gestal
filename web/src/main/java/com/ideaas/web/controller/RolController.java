package com.ideaas.web.controller;

import com.ideaas.services.domain.Rol;
import com.ideaas.services.service.interfaces.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Enzo on 28/2/2020.
 */
@Controller
@RequestMapping("rol")
public class RolController {

    private RolService rolService;

    @Autowired
    public RolController( RolService rolService) {

        this.rolService = rolService;
    }

    @RequestMapping(value = "save")
    public String save(@Valid @ModelAttribute("rol") Rol rol, Errors result, Model map) {

        if (result.hasErrors()) {

            return "rol/create";
        } else {
            rolService.save(rol);

            return "redirect:list";
        }

    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Rol rol = rolService.get(id);
        model.addAttribute("rol", rol);

        return "rol/update";
    }

    @RequestMapping("create")
    public String create(@ModelAttribute("rol") Rol rol) {

        return "rol/create";
    }

    @ModelAttribute("roles")
    public List<Rol> getRoles() {

        return rolService.findAll();
    }

    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "5") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model) {
        List<Rol> roles= rolService.findAll(size, page, "id");
        model.addAttribute("roles", roles);
        model.addAttribute("page", page);

        return "rol/list";
    }
}
