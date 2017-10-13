package com.teamnine.carrepairs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class OwnersController {
    @RequestMapping(value= "/admin/owners", method = RequestMethod.GET)
    public String owners(Model model) {

        return "owners";
    }


}
