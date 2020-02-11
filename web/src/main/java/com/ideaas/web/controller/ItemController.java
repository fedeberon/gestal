package com.ideaas.web.controller;

import com.ideaas.services.domain.Item;
import com.ideaas.services.service.interfaces.ItemService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Enzo on 10/2/2020.
 */
@Controller
@RequestMapping("item")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("items", itemService.findAll());

        return "item/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Item item) {
        itemService.save(item);

        return "redirect:list";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("item") Item item) {

        return "item/create";
    }
}
