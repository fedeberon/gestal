package com.ideaas.web.controller;

import com.ideaas.services.dao.sucursal.SucursalDao;
import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.domain.Sucursal;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import com.ideaas.services.service.interfaces.EvaluacionService;
import com.ideaas.services.service.interfaces.UsuarioService;
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
    private SucursalDao sucursalDao;

    public LoginController(UsuarioService usuarioService, EvaluacionDelColaboradorService evaluacionDelColaboradorService, EvaluacionService evaluacionService, SucursalDao sucursalDao) {
        this.usuarioService = usuarioService;
        this.evaluacionDelColaboradorService = evaluacionDelColaboradorService;
        this.evaluacionService = evaluacionService;
        this.sucursalDao = sucursalDao;
    }

    @RequestMapping(value = {"/home" , ""})
    public String homePage(Model model) {
        List<EvaluacionDelColaborador> evaluacionesDeColaboradores = evaluacionDelColaboradorService.findAll();
        List<Sucursal> sucursales = sucursalDao.findAll();
        model.addAttribute("cantColaboradoresEvaluados", evaluacionesDeColaboradores);
        model.addAttribute("evaluaciones", evaluacionesDeColaboradores);
//        model.addAttribute("score", evaluacionDelColaboradorService.calcularRatingPorConsideracion());
        model.addAttribute("cantidadEvaluacionesMes", evaluacionDelColaboradorService.cantidadEvaluacionesMes());
        model.addAttribute("cantidadEvaluacionesEntreRango", evaluacionDelColaboradorService.cantidadEvaluacionesEntreRango());
        model.addAttribute("cantidadEvaluacionesMayor", evaluacionDelColaboradorService.cantidadEvaluacionesMayor());
        model.addAttribute("cantidadEvaluacionesEnCero", evaluacionDelColaboradorService.cantidadEvaluacionesEnCero());
        model.addAttribute("sucursales", sucursales);

        return "home";
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {

        return "login";
    }

}

