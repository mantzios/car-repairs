package com.teamnine.carrepairs.controller;

import com.teamnine.carrepairs.service.RepairService;
import com.teamnine.carrepairs.service.RepairServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RepairsController {

    @Autowired
    private RepairService repairService;


    @RequestMapping(value= "admin/repairs", method = RequestMethod.GET)
    public String repairs(Model model){
        model.addAttribute("repairs",repairService.findAllRepairs());
        return "repairs";
    }
}
