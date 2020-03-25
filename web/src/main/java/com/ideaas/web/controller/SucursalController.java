package com.ideaas.web.controller;
import com.ideaas.services.bean.State;
import com.ideaas.services.domain.Rol;
import com.ideaas.services.domain.Sucursal;
import com.ideaas.services.service.interfaces.SucursalService;
import com.ideaas.services.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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

    @RequestMapping("create")
    public String create(@ModelAttribute("sucursal") Sucursal sucursal) {
        return "sucursal/create";
    }

    @RequestMapping(value = "save")
    public String save(@Valid @ModelAttribute("sucursal") Sucursal sucursal, Errors result, Model map) {
        if (result.hasErrors()) {
            return "sucursal/create";
        } else {
            sucursalService.save(sucursal);
            return "redirect:list";
        }
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Sucursal sucursal = sucursalService.get(id);
        model.addAttribute("sucursal", sucursal);

        return "sucursal/update";
    }
}
