package com.ideaas.web.controller;

import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.service.interfaces.RolService;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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


    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "5") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model){
        List<EvaluacionDelColaborador> evaluaciones = evaluacionDelColaboradorService.findAllPageable(size, page,"id");
        model.addAttribute("evaluaciones", evaluaciones);
        model.addAttribute("page" , page);

        return "evaluacionDelColaborador/list";
    }

}
