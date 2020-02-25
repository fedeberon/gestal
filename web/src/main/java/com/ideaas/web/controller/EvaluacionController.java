package com.ideaas.web.controller;

import com.google.common.base.Strings;
import com.ideaas.services.bean.State;
import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.Item;
import com.ideaas.services.domain.Rol;
import com.ideaas.services.service.RolService;
import com.ideaas.services.service.interfaces.EvaluacionService;
import com.ideaas.services.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    public String save(@Valid @ModelAttribute("evaluacion") Evaluacion evaluacion, BindingResult result){

        if (result.hasErrors()){

            return "evaluacion/create";
        }
        else {
            evaluacion.getItems().removeIf(item -> item.getValue() == null);
            evaluacion.getItems().forEach(item -> item.setEvaluacion(evaluacion));
            evaluacion.setState(State.ACTIVE);
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

}
