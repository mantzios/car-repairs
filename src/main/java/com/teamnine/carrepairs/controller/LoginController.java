package com.teamnine.carrepairs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

    @RequestMapping(value= "/login", method = RequestMethod.GET)
    public String application(Model model){

        return "login";
    }
}
