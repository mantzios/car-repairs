package com.teamnine.carrepairs.controller;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;


@Controller
public class HomeController {
    private  final static org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);


    @ModelAttribute(name="name")
    String initModel(){
    return "hi";

    }


    @RequestMapping(value= "/home", method = RequestMethod.GET)
    public String home(Model model){
       // model.addAttribute("name","blaaaa")
        return "home";
    }

}
