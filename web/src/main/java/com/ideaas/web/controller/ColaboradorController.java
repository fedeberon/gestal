package com.ideaas.web.controller;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.Rol;
import com.ideaas.services.service.RolService;
import com.ideaas.services.service.interfaces.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * Created by Enzo on 7/2/2020.
 */
@Controller
@RequestMapping("colaborador")
public class ColaboradorController {

    private ColaboradorService colaboradorService;
    private RolService rolService;


    @Autowired
    public ColaboradorController(ColaboradorService colaboradorService, RolService rolService) {

        this.colaboradorService = colaboradorService;
        this.rolService = rolService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("colaboradores", colaboradorService.findAll());

        return "colaborador/list";
    }

    @RequestMapping(value = "save")
    public String save(@Valid Colaborador colaborador, Errors errors, Model map) {

        if (errors.hasErrors()){
            map.addAllAttributes(errors.getAllErrors());
            map.addAttribute("colaborador", colaborador);

            return "colaborador/create";
        }
        else {
            colaboradorService.save(colaborador);

            return "redirect:list";
        }

    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Colaborador colaborador= colaboradorService.get(id);
        model.addAttribute("colaborador", colaborador);

        return "colaborador/update";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("colaborador") Colaborador colaborador) {

        return "colaborador/create";
    }

    @ModelAttribute("roles")
    public List<Rol> getRoles(){

        return rolService.findAll();
    }
}