package com.ideaas.web.controller;

import com.ideaas.services.service.RolService;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import com.ideaas.services.service.interfaces.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Enzo on 17/2/2020.
 */

@Controller
@RequestMapping("evaluacionDelColaborador")
public class EvaluacionDelColaboradorController {

    private RolService rolService;

    private EvaluacionDelColaboradorService evaluacionDelColaboradorService;

    @Autowired
    public EvaluacionDelColaboradorController(RolService rolService, EvaluacionDelColaboradorService evaluacionDelColaboradorService) {
        this.rolService = rolService;
        this.evaluacionDelColaboradorService = evaluacionDelColaboradorService;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("evaluaciones", evaluacionDelColaboradorService.findAll());

        return "evaluacionDelColaborador/list";
    }

}