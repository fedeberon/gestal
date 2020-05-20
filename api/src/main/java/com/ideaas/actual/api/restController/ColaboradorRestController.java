package com.ideaas.actual.api.restController;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.service.interfaces.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by federicoberon on 30/01/2020.
 */
@RestController
@RequestMapping("api/colaborador")
public class ColaboradorRestController {

    private ColaboradorService colaboradorService;

    @Autowired
    public ColaboradorRestController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Colaborador>> findAll(){
        List<Colaborador> colaboradores = colaboradorService.findAll();

        return new ResponseEntity(colaboradores, HttpStatus.OK);
    }
}
