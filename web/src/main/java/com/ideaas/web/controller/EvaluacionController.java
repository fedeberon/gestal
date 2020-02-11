package com.ideaas.web.controller;

import com.ideaas.services.bean.State;
import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.Rol;
import com.ideaas.services.service.RolService;
import com.ideaas.services.service.interfaces.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Enzo on 10/2/2020.
 */
@Controller
@RequestMapping("evaluacion")
public class EvaluacionController {

    private RolService rolService;

    private EvaluacionService evaluacionService;

    @Autowired
    public EvaluacionController(RolService rolService, EvaluacionService evaluacionService) {
        this.rolService = rolService;
        this.evaluacionService = evaluacionService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("evaluaciones", evaluacionService.findAll());

        return "evaluacion/list";
    }

    @RequestMapping("create")
    public String create(){

        return "evaluacion/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute Evaluacion evaluacion){
        evaluacion.getItems().forEach(item -> item.setEvaluacion(evaluacion));
        evaluacion.setState(State.ACTIVE);
        evaluacionService.save(evaluacion);

        return "redirect:list";
    }

    @ModelAttribute("roles")
    public List<Rol> getRoles(){

        return rolService.findAll();
    }

    @ModelAttribute("evaluacion")
    public Evaluacion getEvaluacion(){

        return new Evaluacion();
    }

}
