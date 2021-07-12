package com.ideaas.web.controller;

import com.ideaas.services.domain.*;
import com.ideaas.services.enumeradores.State;
import com.ideaas.services.service.interfaces.ConsideracionService;
import com.ideaas.services.service.interfaces.EvaluacionService;
import com.ideaas.services.service.interfaces.ItemService;
import com.ideaas.services.service.interfaces.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Enzo on 10/2/2020.
 */
@Controller
@RequestMapping("evaluacion")
public class EvaluacionController {

    private PuestoService puestoService;
    private ItemService itemService;
    private EvaluacionService evaluacionService;
    private ConsideracionService consideracionService;

    @Autowired
    public EvaluacionController(PuestoService puestoService, EvaluacionService evaluacionService, ItemService itemService, ConsideracionService consideracionService) {
        this.puestoService = puestoService;
        this.evaluacionService = evaluacionService;
        this.itemService = itemService;
        this.consideracionService = consideracionService;
    }

    @RequestMapping("create")
    public String create(@ModelAttribute("evaluacion") Evaluacion evaluacion){


        return "evaluacion/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute Evaluacion evaluacion, Errors result, Model map){
        if (result.hasErrors()) {

            return "evaluacion/create";
        } else {
            evaluacion.getItems().removeIf(item -> item.getValue() == null);
            evaluacion.getItems().forEach(item -> {
                item.getConsideraciones().removeIf(consideracion -> consideracion.getValue() == null);
                if (item.isInvalidaEvaluacion() == true){
                    evaluacion.getItems().forEach(allItems -> {
                        allItems.setScore(0f);
                    });
                }
                item.setEvaluacion(evaluacion);

            });
            evaluacion.setState(State.ACTIVE);
            evaluacionService.save(evaluacion);
            return "redirect:list";
        }
    }

    @RequestMapping(value = "saveAndUpdate", method = RequestMethod.POST)
    public String saveAndUpdate(@Valid @ModelAttribute Evaluacion evaluacion, Errors result, Model map){
//        evaluacionService.delete(evaluacion);
//        evaluacion.setId(null);
        if (result.hasErrors()) {

            return "evaluacion/create";
        } else {
            evaluacion.getItems().removeIf(item -> item.getValue() == null);
            evaluacion.getItems().forEach(item -> {
                item.getConsideraciones().removeIf(consideracion -> consideracion.getValue() == null);
                if (item.isInvalidaEvaluacion() == true){
                    evaluacion.getItems().forEach(allItems -> {
                        allItems.setScore(0f);
                    });
                }
                item.setEvaluacion(evaluacion);
            });
            evaluacion.setState(State.ACTIVE);
            evaluacionService.save(evaluacion);
            return "redirect:list";
        }
    }

    @ModelAttribute("puestos")
    public List<Puesto> getPuestos(){

        return puestoService.findAll();
    }

    @ModelAttribute("evaluacion")
    public Evaluacion getEvaluacion(Model model){
        return new Evaluacion();
    }

    @RequestMapping("activar")
    public String activarEvaluacion(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Evaluacion evaluacion= evaluacionService.getById(id);
        evaluacion.setState(State.ACTIVE);
        redirectAttributes.addAttribute("id", evaluacion.getId());
        evaluacionService.save(evaluacion);

        return "redirect:list";
    }

    @RequestMapping("desactivar")
    public String desactivarEvaluacion(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Evaluacion evaluacion= evaluacionService.getById(id);
        redirectAttributes.addAttribute("id", evaluacion.getId());
        evaluacionService.desactivarEvaluacion(evaluacion);

        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Evaluacion evaluacion= evaluacionService.getById(id);
        model.addAttribute("evaluacion", evaluacion);

        return "evaluacion/update";
    }

    @RequestMapping("clonar")
    public String clonarEvaluacion(@RequestParam Long id, Model model) {
        Evaluacion evaluacion= evaluacionService.getById(id);
        model.addAttribute("evaluacion", evaluacion);

        return "evaluacion/clonar";
    }

    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model){
        List<Evaluacion> evaluaciones = evaluacionService.findAllPageable(size, page,"id");
        model.addAttribute("evaluaciones", evaluaciones);
        model.addAttribute("page" , page);

        return "evaluacion/list";
    }

    @RequestMapping("/home")
    public String findAll(Model model){
        List<Evaluacion> evaluaciones = evaluacionService.findAll();
        model.addAttribute("evaluaciones", evaluaciones);

        return "redirect:/home";
    }
}