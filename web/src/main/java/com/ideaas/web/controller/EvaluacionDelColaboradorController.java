package com.ideaas.web.controller;

import com.ideaas.services.service.ConsideracionItemEvaluadoService;
import com.ideaas.services.service.interfaces.*;
import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.service.interfaces.ColaboradorService;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import com.ideaas.services.service.interfaces.EvaluacionService;
import com.ideaas.services.service.interfaces.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * Created by Enzo on 17/2/2020.
 */

@Controller
@RequestMapping("evaluacionDelColaborador")
public class EvaluacionDelColaboradorController {

    private PuestoService rolService;

    private EvaluacionDelColaboradorService evaluacionDelColaboradorService;
    private EvaluacionService evaluacionService;
    private ColaboradorService colaboradorService;
    private ItemService itemService;
    private ConsideracionItemEvaluadoService consideracionItemEvaluadoService;

    @Autowired
    public EvaluacionDelColaboradorController(PuestoService rolService, EvaluacionDelColaboradorService evaluacionDelColaboradorService, EvaluacionService evaluacionService, ColaboradorService colaboradorService, ItemService itemService, ConsideracionItemEvaluadoService consideracionItemEvaluadoService) {
        this.rolService = rolService;
        this.evaluacionDelColaboradorService = evaluacionDelColaboradorService;
        this.evaluacionService = evaluacionService;
        this.colaboradorService = colaboradorService;
        this.itemService = itemService;
        this.consideracionItemEvaluadoService = consideracionItemEvaluadoService;
    }

    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model) {

        List<EvaluacionDelColaborador> evaluaciones = evaluacionDelColaboradorService.findAllPageable(size,page,"id");
        evaluaciones.forEach(evaluacionDelColaborador -> {
            evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> {
                if (itemEvaluado.getItem().isInvalidaEvaluacion() == true){
                    Float scoreEnCero = 0f;
                    model.addAttribute("score0", scoreEnCero);
                    evaluacionDelColaborador.setResultado(0f);
                }
            });
        });
        model.addAttribute("evaluaciones", evaluaciones);
        model.addAttribute("page", page);
        model.addAttribute("consideracionItemEvaluado", consideracionItemEvaluadoService.findAll());

        return "evaluacionDelColaborador/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@RequestParam Long id, Model model) {
        Colaborador colaborador = colaboradorService.get(id);
        Evaluacion evaluacion = evaluacionService.getByPuesto(colaborador.getPuesto());
        List <Evaluacion> evaluaciones = evaluacionService.findAll();

        model.addAttribute("colaborador", colaborador);
        model.addAttribute("evaluacion", evaluacion);
        model.addAttribute("evaluaciones", evaluaciones);

        return "evaluacionDelColaborador/create";
    }

    @ModelAttribute("evaluacionDelColaborador")
    public EvaluacionDelColaborador getEvaluacionDelColaborador() {
        return new EvaluacionDelColaborador();
    }

    @RequestMapping(value = "save")
    public String save(@Valid @ModelAttribute("evaluacionDelColaborador") EvaluacionDelColaborador evaluacionDelColaborador, Errors result, Model map) {
        if (result.hasErrors()) {
            return "colaborador/create";

        } else {
            evaluacionDelColaboradorService.save(evaluacionDelColaborador);
            return "redirect:list";
        }
    }

    @RequestMapping("/search")
    public String findColaboradorByName(@RequestParam(defaultValue = "") String value, Model model) {
        model.addAttribute("evaluaciones", evaluacionDelColaboradorService.findColaboradorByName(value));
        return "evaluacionDelColaborador/list";
    }
}