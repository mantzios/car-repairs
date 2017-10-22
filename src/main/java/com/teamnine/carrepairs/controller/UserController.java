package com.teamnine.carrepairs.controller;

import com.teamnine.carrepairs.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private static final String REPAIR_USER="repairsOwners";

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String userPage(Model model, HttpServletRequest request){
        String email= (String) request.getSession().getAttribute("email");
        model.addAttribute(REPAIR_USER,repairService.searchByEmail(email));
        return "user";
    }
}
