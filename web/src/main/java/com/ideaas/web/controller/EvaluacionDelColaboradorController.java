package com.ideaas.web.controller;

import com.ideaas.services.domain.*;
import com.ideaas.services.enumeradores.EstadoEvaluacion;
import com.ideaas.services.enumeradores.State;
import com.ideaas.services.service.ConsideracionItemEvaluadoService;
import com.ideaas.services.service.interfaces.*;
import com.ideaas.services.service.interfaces.ColaboradorService;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import com.ideaas.services.service.interfaces.EvaluacionService;
import com.ideaas.services.service.interfaces.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    private ItemEvaluadoService itemEvaluadoService;

    @Autowired
    public EvaluacionDelColaboradorController(PuestoService rolService, EvaluacionDelColaboradorService evaluacionDelColaboradorService, EvaluacionService evaluacionService, ColaboradorService colaboradorService, ItemService itemService, ConsideracionItemEvaluadoService consideracionItemEvaluadoService, ItemEvaluadoService itemEvaluadoService) {
        this.rolService = rolService;
        this.evaluacionDelColaboradorService = evaluacionDelColaboradorService;
        this.evaluacionService = evaluacionService;
        this.colaboradorService = colaboradorService;
        this.itemService = itemService;
        this.consideracionItemEvaluadoService = consideracionItemEvaluadoService;
        this.itemEvaluadoService = itemEvaluadoService;
    }

    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model) {

        String authentication = SecurityContextHolder.getContext().getAuthentication().getName();
        Colaborador colaborador = colaboradorService.getUsername(authentication);
        String rol = String.valueOf(colaborador.getRoles().stream().findFirst().get().getName());

        List<EvaluacionDelColaborador> evaluacionesDelAdmin = evaluacionDelColaboradorService.findAllPageable(10, page, "id");
        List<EvaluacionDelColaborador> evaluacionesDelColaborador = evaluacionDelColaboradorService.findByColaborador(colaborador.getId());

        switch (rol){
            case "COLABORADOR":
                evaluacionesDelColaborador.forEach(evaluacionDelColaborador -> {
                evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> {
                    if (itemEvaluado.getItem().isInvalidaEvaluacion() == true){
                        Float scoreEnCero = 0f;
                        model.addAttribute("score0", scoreEnCero);
                        evaluacionDelColaborador.setResultado(0f);
                    }
                });
                });
                model.addAttribute("evaluaciones", evaluacionesDelColaborador);
                break;
            case "ADMIN":
                evaluacionesDelAdmin.forEach(evaluacionDelColaborador -> {
                    evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> {
                        if (itemEvaluado.getItem().isInvalidaEvaluacion() == true){
                            Float scoreEnCero = 0f;
                            model.addAttribute("score0", scoreEnCero);
                            evaluacionDelColaborador.setResultado(0f);
                        }
                    });
                });
                model.addAttribute("evaluaciones", evaluacionesDelAdmin);
                break;
        }
        model.addAttribute("page", page);
        model.addAttribute("consideracionItemEvaluado", consideracionItemEvaluadoService.findAll());

        return "evaluacionDelColaborador/list";
    }

    @RequestMapping("/pendiente")
    public String pendientes(@RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model) {

        String authentication = SecurityContextHolder.getContext().getAuthentication().getName();
        Colaborador colaborador = colaboradorService.getUsername(authentication);
        String rol = String.valueOf(colaborador.getRoles().stream().findFirst().get().getName());

        List<EvaluacionDelColaborador> evaluacionesDelAdmin = StreamSupport
        .stream(evaluacionDelColaboradorService.findAllPageable(10, page, "id").spliterator(), false)
        .filter(evaluacionDelColaborador -> evaluacionDelColaborador.getEstadoEvaluacion() == EstadoEvaluacion.PENDIENTE)
        .collect(Collectors.toList());

        List<EvaluacionDelColaborador> evaluacionesDelColaborador = StreamSupport
                .stream(evaluacionDelColaboradorService.findByColaborador(colaborador.getId()).spliterator(), false)
                .filter(evaluacionDelColaborador -> evaluacionDelColaborador.getEstadoEvaluacion() == EstadoEvaluacion.PENDIENTE)
                .collect(Collectors.toList());

        switch (rol){
            case "COLABORADOR":
                evaluacionesDelColaborador.forEach(evaluacionDelColaborador -> {
                    evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> {
                        if (itemEvaluado.getItem().isInvalidaEvaluacion() == true){
                            Float scoreEnCero = 0f;
                            model.addAttribute("score0", scoreEnCero);
                            evaluacionDelColaborador.setResultado(0f);
                        }
                    });
                });
                model.addAttribute("evaluaciones", evaluacionesDelColaborador);
                break;
            case "ADMIN":
                evaluacionesDelAdmin.forEach(evaluacionDelColaborador -> {
                    evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> {
                        if (itemEvaluado.getItem().isInvalidaEvaluacion() == true){
                            Float scoreEnCero = 0f;
                            model.addAttribute("score0", scoreEnCero);
                            evaluacionDelColaborador.setResultado(0f);
                        }
                    });
                });
                model.addAttribute("evaluaciones", evaluacionesDelAdmin);
                break;
        }
        model.addAttribute("page", page);
        model.addAttribute("consideracionItemEvaluado", consideracionItemEvaluadoService.findAll());

        return "evaluacionDelColaborador/list";
    }

    @RequestMapping("/finalizada")
    public String finalizadas(@RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model) {

        String authentication = SecurityContextHolder.getContext().getAuthentication().getName();
        Colaborador colaborador = colaboradorService.getUsername(authentication);
        String rol = String.valueOf(colaborador.getRoles().stream().findFirst().get().getName());

        List<EvaluacionDelColaborador> evaluacionesDelAdmin = StreamSupport
                .stream(evaluacionDelColaboradorService.findAllPageable(10, page, "id").spliterator(), false)
                .filter(evaluacionDelColaborador -> evaluacionDelColaborador.getEstadoEvaluacion() == EstadoEvaluacion.FINALIZADA)
                .collect(Collectors.toList());

        List<EvaluacionDelColaborador> evaluacionesDelColaborador = StreamSupport
        .stream(evaluacionDelColaboradorService.findByColaborador(colaborador.getId()).spliterator(), false)
        .filter(evaluacionDelColaborador -> evaluacionDelColaborador.getEstadoEvaluacion() == EstadoEvaluacion.FINALIZADA)
        .collect(Collectors.toList());

        switch (rol){
            case "COLABORADOR":
                evaluacionesDelColaborador.forEach(evaluacionDelColaborador -> {
                    evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> {
                        if (itemEvaluado.getItem().isInvalidaEvaluacion() == true){
                            Float scoreEnCero = 0f;
                            model.addAttribute("score0", scoreEnCero);
                            evaluacionDelColaborador.setResultado(0f);
                        }
                    });
                });
                model.addAttribute("evaluaciones", evaluacionesDelColaborador);
                break;
            case "ADMIN":
                evaluacionesDelAdmin.forEach(evaluacionDelColaborador -> {
                    evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> {
                        if (itemEvaluado.getItem().isInvalidaEvaluacion() == true){
                            Float scoreEnCero = 0f;
                            model.addAttribute("score0", scoreEnCero);
                            evaluacionDelColaborador.setResultado(0f);
                        }
                    });
                });
                model.addAttribute("evaluaciones", evaluacionesDelAdmin);
                break;
        }
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
    public String save(@Valid @ModelAttribute("evaluacionDelColaborador") EvaluacionDelColaborador evaluacionDelColaborador, Errors result){
        if (result.hasErrors()) {
            return "colaborador/create";

        } else {
            evaluacionDelColaborador.setState(State.ACTIVE);
            evaluacionDelColaborador.setEstadoEvaluacion(EstadoEvaluacion.PENDIENTE);
            evaluacionDelColaboradorService.save(evaluacionDelColaborador);
            return "redirect:list";
        }
    }

    @RequestMapping("/search")
    public String findColaboradorByName(@RequestParam(defaultValue = "") String value, Model model) {
        model.addAttribute("evaluaciones", evaluacionDelColaboradorService.findColaboradorByName(value));
        return "evaluacionDelColaborador/list";
    }

    @RequestMapping("desactivar")
    public String desactivarEvaluacion(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        EvaluacionDelColaborador evaluacionDelColaborador= evaluacionDelColaboradorService.getById(id);
        evaluacionDelColaborador.setState(State.INACTIVE);
        redirectAttributes.addAttribute("id", evaluacionDelColaborador.getId());
        evaluacionDelColaboradorService.save(evaluacionDelColaborador);

        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        List<List<ConsideracionItemEvaluado>> consideracionesEvaluadas = new ArrayList<>();

        EvaluacionDelColaborador evaluacionDelColaborador = evaluacionDelColaboradorService.get(id);
        List<ItemEvaluado> itemEvaluados = itemEvaluadoService.findByEvaluacionDelColaboradorId(evaluacionDelColaborador.getId()).stream().collect(Collectors.toList());
        model.addAttribute("evaluacionDelColaborador", evaluacionDelColaborador);
        model.addAttribute("evaluacion", evaluacionDelColaborador.getItemEvaluados().get(0).getItem().getEvaluacion());
        model.addAttribute("consideracionesEvaluadas", consideracionesEvaluadas);

        itemEvaluados.forEach(itemEvaluado -> {
            List<ConsideracionItemEvaluado> consideracionItemEvaluados = consideracionItemEvaluadoService.findByItemEvaluadoId(itemEvaluado.getId());
            consideracionesEvaluadas.add(consideracionItemEvaluados);
        });

        return "evaluacionDelColaborador/update";
    }

    @RequestMapping(value = "saveAndUpdate", method = RequestMethod.POST)
    public String saveAndUpdate(@ModelAttribute("evaluacionDelColaborador") EvaluacionDelColaborador evaluacionDelColaborador) {
        evaluacionDelColaborador.getItemEvaluados().removeAll(evaluacionDelColaborador.getItemEvaluados());
        evaluacionDelColaborador.setEstadoEvaluacion(EstadoEvaluacion.FINALIZADA);
        evaluacionDelColaborador.setState(State.ACTIVE);
        evaluacionDelColaboradorService.save(evaluacionDelColaborador);
        return "redirect:list";
    }
}