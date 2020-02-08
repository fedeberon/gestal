package com.ideaas.web.controller;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.service.interfaces.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Enzo on 7/2/2020.
 */
@Controller
@RequestMapping("colaborador")
public class ColaboradorController {

    private ColaboradorService colaboradorService;

    @Autowired
    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("colaboradores", colaboradorService.findAll());

        return "colaborador/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Colaborador colaborador, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("id", colaborador.getId());

        return "colaborador/list";
    }
}