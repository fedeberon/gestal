package com.ideaas.web.controller;

import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.domain.Item;
import com.ideaas.services.service.interfaces.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("evaluacion")
public class EvaluacionController {

    private EvaluacionService evaluacionService;

    @Autowired
    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(EvaluacionDelColaborador evaluacionDelColaborador) {
        evaluacionService.save(evaluacionDelColaborador);
        return "redirect:list";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("evaluacionDelColaborador") EvaluacionDelColaborador evaluacionDelColaborador) {
        return "evaluacion/create";
    }

}