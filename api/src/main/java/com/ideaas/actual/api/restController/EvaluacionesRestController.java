package com.ideaas.actual.api.restController;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.service.interfaces.ColaboradorService;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/evaluaciones")
public class EvaluacionesRestController {

    private EvaluacionDelColaboradorService evaluacionDelColaboradorService;
    private ColaboradorService colaboradorService;

    public EvaluacionesRestController(EvaluacionDelColaboradorService evaluacionDelColaboradorService, ColaboradorService colaboradorService) {
        this.evaluacionDelColaboradorService = evaluacionDelColaboradorService;
        this.colaboradorService = colaboradorService;
    }

    @RequestMapping("list/{page}/{textToSearch}")
    public ResponseEntity<List<EvaluacionDelColaborador>> findAll(@PathVariable Integer page, @PathVariable String textToSearch){
        List<EvaluacionDelColaborador> evaluaciones = evaluacionDelColaboradorService.findAllPageable(10, page, "id");

        return ResponseEntity.ok(evaluaciones);
    }


    @RequestMapping("list/{page}")
    public ResponseEntity<List<EvaluacionDelColaborador>> findAll(@PathVariable Integer page){
        String authentication = SecurityContextHolder.getContext().getAuthentication().getName();
        Colaborador colaborador = colaboradorService.getUsername(authentication);
        String rol = String.valueOf(colaborador.getRoles().stream().findFirst().get().getName());
        List<EvaluacionDelColaborador> evaluacionesDelAdmin = evaluacionDelColaboradorService.findAllPageable(10, page, "id");
        List<EvaluacionDelColaborador> evaluacionesDelColaborador = evaluacionDelColaboradorService.findByColaborador(colaborador.getId());

        switch (rol){
            case "COLABORADOR":
                evaluacionesDelColaborador.forEach(line -> line.getItemEvaluados().forEach(itemEvaluado -> itemEvaluado.setConsideracionItemEvaluados(null)));
                return ResponseEntity.ok(evaluacionesDelColaborador);
            case "ADMIN":
                evaluacionesDelAdmin.forEach(line -> line.getItemEvaluados().forEach(itemEvaluado -> itemEvaluado.setConsideracionItemEvaluados(null)));
                return ResponseEntity.ok(evaluacionesDelAdmin);
        }
        return null;
    }
}
