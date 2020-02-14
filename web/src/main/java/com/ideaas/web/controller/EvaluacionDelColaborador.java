package com.ideaas.web.controller;

import com.ideaas.services.service.RolService;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Enzo on 14/2/2020.
 */
@Controller
@RequestMapping("evaluacionDelColaborador")
public class EvaluacionDelColaborador {

    private EvaluacionDelColaboradorService evaluacionDelColaboradorService;
    private RolService rolService;

    @Autowired
    public EvaluacionDelColaborador(EvaluacionDelColaboradorService evaluacionDelColaboradorService, RolService rolService) {

        this.evaluacionDelColaboradorService = evaluacionDelColaboradorService;
        this.rolService = rolService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("evaluaciones", evaluacionDelColaboradorService.findAll());

        return "evaluacionDelColaborador/list";
    }
}
