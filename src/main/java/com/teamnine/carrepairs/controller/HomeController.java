package com.teamnine.carrepairs.controller;


import com.teamnine.carrepairs.service.RepairService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HomeController {
    private  final static org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private RepairService repairService;



    @RequestMapping(value= "/admin/home", method = RequestMethod.GET)
    public String repairs(Model model){

        model.addAttribute("repairs",repairService.findAllRepairs());

        return "home";
    }

}
