package com.ideaas.web.controller;

import com.ideaas.services.domain.*;
import com.ideaas.services.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Enzo on 7/2/2020.
 */
@Controller
@RequestMapping("colaborador")
public class ColaboradorController {

    private ColaboradorService colaboradorService;
    private RolService rolService;
    private SucursalService sucursalService;
    private EvaluacionService evaluacionService;
    private ItemService itemService;
    @Autowired
    public ColaboradorController(ColaboradorService colaboradorService, RolService rolService, SucursalService sucursalService, EvaluacionService evaluacionService, ItemService itemService) {

        this.colaboradorService = colaboradorService;
        this.rolService = rolService;
        this.sucursalService = sucursalService;
        this.evaluacionService = evaluacionService;
        this.itemService = itemService;
    }

    @RequestMapping(value = "save")
    public String save(@Valid @ModelAttribute("colaborador") Colaborador colaborador, Errors result, Model map) {

        if (result.hasErrors()) {

            return "colaborador/create";
        } else {

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String pass = bCryptPasswordEncoder.encode(colaborador.getPassword());
            colaborador.setPassword(pass);
            colaboradorService.save(colaborador);

            return "redirect:list";
        }

    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Colaborador colaborador = colaboradorService.get(id);
        model.addAttribute("colaborador", colaborador);

        return "colaborador/update";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("colaborador") Colaborador colaborador) {

         return "colaborador/create";
    }

    @ModelAttribute("roles")
    public List<Rol> getRoles() {

        return rolService.findAll();
    }

    @ModelAttribute("sucursales")
    public List<Sucursal> getSucursales() {

        return sucursalService.findAll();
    }

    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "5") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model) {
        List<Colaborador> colaboradores = colaboradorService.findAll(size, page, "id");
        List<Evaluacion> evaluaciones = evaluacionService.findAll();

        model.addAttribute("evaluaciones", evaluaciones);
        model.addAttribute("colaboradores", colaboradores);
        model.addAttribute("page", page);

        return "colaborador/list";
    }
}