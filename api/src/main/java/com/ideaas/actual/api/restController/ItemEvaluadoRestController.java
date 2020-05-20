package com.ideaas.actual.api.restController;

import com.ideaas.services.domain.ConsideracionItemEvaluado;
import com.ideaas.services.domain.ItemEvaluado;
import com.ideaas.services.service.interfaces.ItemEvaluadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/itemEvaluado")
public class ItemEvaluadoRestController {

    private ItemEvaluadoService itemEvaluadoService;

    @Autowired
    public ItemEvaluadoRestController(ItemEvaluadoService itemEvaluadoService) {
        this.itemEvaluadoService = itemEvaluadoService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/consideracionesEvaluadas/{id}")
    public @ResponseBody List<ConsideracionItemEvaluado> findConsideracionesEvaludas(@PathVariable Long id){
        ItemEvaluado itemEvaluado = itemEvaluadoService.get(id);
        List<ConsideracionItemEvaluado>  consideraciones = new ArrayList<>();
        itemEvaluado.getConsideracionItemEvaluados().forEach(line -> consideraciones.add(new ConsideracionItemEvaluado(line.getConsideracion(), line.isCheckeado())));

        return consideraciones;
    }

}
