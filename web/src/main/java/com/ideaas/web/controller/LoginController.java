package com.ideaas.web.controller;

import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import com.ideaas.services.service.interfaces.EvaluacionService;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {
    private UsuarioService usuarioService;
    private EvaluacionDelColaboradorService evaluacionDelColaboradorService;
    private EvaluacionService evaluacionService;

    public LoginController(UsuarioService usuarioService, EvaluacionDelColaboradorService evaluacionDelColaboradorService, EvaluacionService evaluacionService) {
        this.usuarioService = usuarioService;
        this.evaluacionDelColaboradorService = evaluacionDelColaboradorService;
        this.evaluacionService = evaluacionService;
    }

    @RequestMapping(value = {"/home" , ""})
    public String homePage(Model model) {
        List<EvaluacionDelColaborador> evaluacionesDeColaboradores = evaluacionDelColaboradorService.findAll();
        List<Evaluacion> evaluaciones = evaluacionService.findAll();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            model.addAttribute("usuario", username);
        } else {
            String username = principal.toString();
        }
        model.addAttribute("cantColaboradoresEvaluados", evaluacionesDeColaboradores);
        model.addAttribute("evaluaciones", evaluaciones);
        return "home";
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {

        return "login";
    }

}

