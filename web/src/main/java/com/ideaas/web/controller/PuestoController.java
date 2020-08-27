package com.ideaas.web.controller;

import com.ideaas.services.domain.Puesto;
import com.ideaas.services.service.interfaces.PuestoService;
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
@RequestMapping("puesto")
public class PuestoController {

    private PuestoService puestoService;

    @Autowired
    public PuestoController(PuestoService puestoService) {

        this.puestoService = puestoService;
    }

    @RequestMapping(value = "save")
    public String save(@Valid @ModelAttribute("puesto") Puesto puesto, Errors result) {

        if (result.hasErrors()) {

            return "puesto/create";
        } else {
            puestoService.save(puesto);

            return "redirect:list";
        }

    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Puesto puesto = puestoService.get(id);
        model.addAttribute("puesto", puesto);

        return "puesto/update";
    }

    @RequestMapping("create")
    public String create(@ModelAttribute("puesto") Puesto puesto) {

        return "puesto/create";
    }

    @ModelAttribute("puestos")
    public List<Puesto> getPuestos() {

        return puestoService.findAll();
    }

    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model) {
        List<Puesto> puestos= puestoService.findAll(size, page, "id");
        model.addAttribute("puestos", puestos);
        model.addAttribute("page", page);

        return "puesto/list";
    }
}
