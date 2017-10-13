package com.teamnine.carrepairs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RepairsController {
    @RequestMapping(value= "admin/repairs", method = RequestMethod.GET)
    public String repairs(Model model){

        return "repairs";
    }
}
