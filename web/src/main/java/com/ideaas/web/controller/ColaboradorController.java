package com.ideaas.web.controller;

import com.ideaas.services.bean.State;
import com.ideaas.services.domain.*;
import com.ideaas.services.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Enzo on 7/2/2020.
 */
@Controller
@RequestMapping("colaborador")
public class ColaboradorController {

    private ColaboradorService colaboradorService;
    private PuestoService puestoService;
    private SucursalService sucursalService;
    private EvaluacionService evaluacionService;
    private ItemService itemService;
    private RolService rolService;
    @Autowired
    public ColaboradorController(ColaboradorService colaboradorService, PuestoService puestoService, SucursalService sucursalService, EvaluacionService evaluacionService, ItemService itemService, RolService rolService) {

        this.colaboradorService = colaboradorService;
        this.puestoService = puestoService;
        this.sucursalService = sucursalService;
        this.evaluacionService = evaluacionService;
        this.itemService = itemService;
        this.rolService = rolService;
    }

    @RequestMapping(value = "save")
    public String save(@ModelAttribute("colaborador") Colaborador colaborador, Model model) {
        Colaborador existingEmail = colaboradorService.validateEmail(colaborador.getEmail());
        Colaborador existingUsername = colaboradorService.validateUsername(colaborador.getUsername());

        if (existingUsername != null){
            model.addAttribute("errorUsername", "Este nombre de usuario ya existe");
            return "colaborador/create";
        }
        if (existingEmail != null) {
            model.addAttribute("errorEmail", "Este email ya existe");
            return "colaborador/create";
        }
        else
        {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String pass = bCryptPasswordEncoder.encode(colaborador.getPassword());
            colaborador.setPassword(pass);
            colaborador.setState(State.ACTIVE);
            colaboradorService.save(colaborador);
        }
        return "redirect:list";
        }

    @RequestMapping("updateUsername")
    public String updateUsername(@RequestParam Long id, Model model) {
        Colaborador colaborador = colaboradorService.get(id);
        model.addAttribute("colaborador", colaborador);
        return "colaborador/updateUsername";
    }
    @RequestMapping("saveAndUpdateUsername")
    public String saveAndUpdateUsername(@ModelAttribute("colaborador") Colaborador colaborador, Model model){
        Colaborador existingUsername = colaboradorService.validateUsername(colaborador.getUsername());

        if (existingUsername != null){
            model.addAttribute("errorUsername", "Este nombre de usuario ya existe");
            return "colaborador/updateUsername";
        }else {
            colaborador.setState(State.ACTIVE);
            colaboradorService.save(colaborador);
            return "redirect:list";
        }
    }

    @RequestMapping("updateEmail")
    public String updateEmail(@RequestParam Long id, Model model) {
        Colaborador colaborador = colaboradorService.get(id);
        model.addAttribute("colaborador", colaborador);
        return "colaborador/updateEmail";
    }
    @RequestMapping("saveAndUpdateEmail")
    public String saveAndUpdateEmail(@ModelAttribute("colaborador") Colaborador colaborador, Model model){
        Colaborador existingEmail = colaboradorService.validateEmail(colaborador.getEmail());

        if (existingEmail != null){
            model.addAttribute("errorEmail", "Este email ya existe");
            return "colaborador/updateEmail";
        }else {
            colaborador.setState(State.ACTIVE);
            colaboradorService.save(colaborador);
            return "redirect:list";
        }
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Colaborador colaborador = colaboradorService.get(id);
        model.addAttribute("colaborador", colaborador);
        return "colaborador/update";
    }

    @RequestMapping("saveAndUpdate")
    public String saveAndUpdate(@ModelAttribute("colaborador") Colaborador colaborador, Model model) {
        colaborador.setState(State.ACTIVE);
        colaboradorService.save(colaborador);
        return "redirect:list";
    }

    @RequestMapping("baja")
    public String darDeBajaColaborador(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Colaborador colaborador= colaboradorService.get(id);
        colaborador.setState(State.INACTIVE);
        redirectAttributes.addAttribute("id", colaborador.getId());
        colaboradorService.save(colaborador);

        return "redirect:list";
    }

    @RequestMapping("alta")
    public String darDeAltaColaborador(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Colaborador colaborador= colaboradorService.get(id);
        colaborador.setState(State.ACTIVE);
        redirectAttributes.addAttribute("id", colaborador.getId());
        colaboradorService.save(colaborador);

        return "redirect:list";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("colaborador") Colaborador colaborador) {

         return "colaborador/create";
    }

    @ModelAttribute("puestos")
    public List<Puesto> getPuestos() {

        return puestoService.findAll();
    }

    @ModelAttribute("sucursales")
    public List<Sucursal> getSucursales() {

        return sucursalService.findAll();
    }

    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model) {
        List<Colaborador> colaboradores = colaboradorService.findAll(size, page, "id");
        List<Evaluacion> evaluaciones = evaluacionService.findAll();

        model.addAttribute("evaluaciones", evaluaciones);
        model.addAttribute("colaboradores", colaboradores);
        model.addAttribute("page", page);

        return "colaborador/list";
    }

    @RequestMapping("/search")
    public String findColaboradorByName(@RequestParam(defaultValue = "") String value, Model model) {
        model.addAttribute("colaboradores", colaboradorService.findColaboradorByName(value));
        return "colaborador/list";
    }

    @ModelAttribute("roles")
    public List<Rol> getRoles() {
        return rolService.findAll();
    }

}