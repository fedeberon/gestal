package com.ideaas.actual.api.restController;

import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.domain.Puesto;
import com.ideaas.services.domain.Rol;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import com.ideaas.services.service.interfaces.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Created by federicoberon on 04/02/2020.
 */
@RestController
@RequestMapping("api/evaluacion")
public class EvaluacionRestController {

    private EvaluacionService evaluacionService;
    private EvaluacionDelColaboradorService evaluacionDelColaboradorService;

    @Autowired
    public EvaluacionRestController(EvaluacionService evaluacionService, EvaluacionDelColaboradorService evaluacionDelColaboradorService) {
        this.evaluacionService = evaluacionService;
        this.evaluacionDelColaboradorService = evaluacionDelColaboradorService;
    }


    @RequestMapping(value = "byPuesto", method = RequestMethod.POST)
    public ResponseEntity<Evaluacion> getByPuesto(@RequestBody Puesto puesto){
        Evaluacion evaluacion = evaluacionService.getByPuesto(puesto);

        if(Objects.isNull(evaluacion)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(evaluacion, HttpStatus.OK);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody EvaluacionDelColaborador save(@RequestBody EvaluacionDelColaborador evaluacionDelColaborador){
        EvaluacionDelColaborador evaluacion = evaluacionDelColaboradorService.save(evaluacionDelColaborador);
        evaluacion.getItemEvaluados().forEach(itemEvaluado -> itemEvaluado.setConsideracionItemEvaluados(null));
        return evaluacion;
    }

}
