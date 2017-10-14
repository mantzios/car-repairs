package com.teamnine.carrepairs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @RequestMapping(value= "/login", method = RequestMethod.GET)
    public String application(Model model,@RequestParam(name = "error", required = false) String error){
        if (error != null) {
            model.addAttribute("error_message","Wrong password or username");
        }
        return "login";
    }
}
