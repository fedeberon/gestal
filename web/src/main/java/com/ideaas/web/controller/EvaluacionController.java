package com.ideaas.web.controller;

import com.ideaas.services.bean.State;
import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.Rol;
import com.ideaas.services.service.interfaces.EvaluacionService;
import com.ideaas.services.service.interfaces.ItemService;
import com.ideaas.services.service.interfaces.RolService;
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
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Enzo on 10/2/2020.
 */
@Controller
@RequestMapping("evaluacion")
public class EvaluacionController {

    private RolService rolService;
    private ItemService itemService;
    private EvaluacionService evaluacionService;

    @Autowired
    public EvaluacionController(RolService rolService, EvaluacionService evaluacionService, ItemService itemService) {
        this.rolService = rolService;
        this.evaluacionService = evaluacionService;
        this.itemService = itemService;
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
            evaluacionService.save(evaluacion);
            return "redirect:list";
        }
    }

    @ModelAttribute("roles")
    public List<Rol> getRoles(){

        return rolService.findAll();
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
        evaluacion.setState(State.INACTIVE);
        redirectAttributes.addAttribute("id", evaluacion.getId());
        evaluacionService.save(evaluacion);

        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Evaluacion evaluacion= evaluacionService.getById(id);
        model.addAttribute("evaluacion", evaluacion);

        return "evaluacion/update";
    }

    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model){
        List<Evaluacion> evaluaciones = evaluacionService.findAllPageable(size, page,"id");
        List<Evaluacion> asd = evaluacionService.findAll();
        model.addAttribute("evaluaciones", evaluaciones);
        model.addAttribute("asd", asd);

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