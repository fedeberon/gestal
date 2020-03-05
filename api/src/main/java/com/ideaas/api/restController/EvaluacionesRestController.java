package com.ideaas.api.restController;

import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/evaluaciones")
public class EvaluacionesRestController {

    private EvaluacionDelColaboradorService evaluacionDelColaboradorService;

    public EvaluacionesRestController(EvaluacionDelColaboradorService evaluacionDelColaboradorService) {
        this.evaluacionDelColaboradorService = evaluacionDelColaboradorService;
    }

    @RequestMapping("list/{page}")
    public ResponseEntity<List<EvaluacionDelColaborador>> findAll(@PathVariable Integer page){
        List<EvaluacionDelColaborador> evaluaciones = evaluacionDelColaboradorService.findAllPageable(10, page, "id");

        return ResponseEntity.ok(evaluaciones);
    }
}
