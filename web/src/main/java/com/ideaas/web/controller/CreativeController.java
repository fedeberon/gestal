package com.ideaas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by federicoberon on 31/10/2019.
 */
@Controller
@RequestMapping
public class CreativeController {


    @RequestMapping("creative-new")
    public String create(){
        return "creative/new";
    }

}
