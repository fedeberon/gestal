package com.ideaas.api.restController;

import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.domain.Rol;
import com.ideaas.services.service.interfaces.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by federicoberon on 04/02/2020.
 */
@RestController
@RequestMapping("api/evaluacion")
public class EvaluacionRestController {

    private EvaluacionService evaluacionService;

    @Autowired
    public EvaluacionRestController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @RequestMapping(value = "byRol", method = RequestMethod.POST)
    public ResponseEntity<Evaluacion> getByRol(@RequestBody Rol rol){
        Evaluacion evaluacion = evaluacionService.getByRol(rol.getName());

        return new ResponseEntity(evaluacion, HttpStatus.OK);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<EvaluacionDelColaborador> save(@RequestBody EvaluacionDelColaborador evaluacionDelColaborador){
        evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> itemEvaluado.setEvaluacionDelColaborador(evaluacionDelColaborador));
        EvaluacionDelColaborador evaluacion = evaluacionService.save(evaluacionDelColaborador);

        return new ResponseEntity(evaluacion, HttpStatus.OK);
    }

}
