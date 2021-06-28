package com.ideaas.web.controller;
import com.ideaas.services.enumeradores.State;
import com.ideaas.services.domain.Sucursal;
import com.ideaas.services.service.interfaces.SucursalService;
import com.ideaas.services.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String findAllPageable(@RequestParam(defaultValue = "10") Integer size,
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
    public String save(@ModelAttribute("sucursal") Sucursal sucursal) {
        sucursal.setState(State.ACTIVE);
        sucursalService.save(sucursal);
        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Sucursal sucursal = sucursalService.get(id);
        model.addAttribute("sucursal", sucursal);

        return "sucursal/update";
    }

    @RequestMapping("desactivar")
    public String desactivarSucursal(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Sucursal sucursal= sucursalService.getById(id);
        sucursal.setState(State.INACTIVE);
        redirectAttributes.addAttribute("id", sucursal.getId());
        sucursalService.save(sucursal);

        return "redirect:list";
    }
}
