package com.ideaas.web.controller;
import com.ideaas.services.bean.State;
import com.ideaas.services.domain.Evaluacion;
import com.ideaas.services.domain.Sucursal;
import com.ideaas.services.service.interfaces.EvaluacionService;
import com.ideaas.services.service.interfaces.RolService;
import com.ideaas.services.service.interfaces.SucursalService;
import com.ideaas.services.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("sucursal")
public class SucursalController {

    private SucursalService sucursalService;
    private ItemService itemService;

    @Autowired
    public SucursalController(SucursalService sucursalService,ItemService itemService) {
        this.sucursalService = sucursalService;
        this.itemService = itemService;
    }

    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "5") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model){
        List <Sucursal> sucursales = sucursalService.findAllPageable(size, page,"id");
        model.addAttribute("sucursales", sucursales);
        model.addAttribute("page" , page);

        return "sucursal/list";
    }
}
