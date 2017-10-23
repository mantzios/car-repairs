package com.teamnine.carrepairs.controller;


import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.model.SearchRepairByDate;
import com.teamnine.carrepairs.service.RepairService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class HomeController {

    private  final static org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static final String SEARCH_REPAIR_BY_DATE = "searchRepairByDate";

    List<Repair> repairs;

    @Autowired
    private RepairService repairService;



    @RequestMapping(value= "/admin/home", method = RequestMethod.GET)
    public String repairs(Model model){

        model.addAttribute("repairs",repairService.findAllRepairs());
        model.addAttribute(SEARCH_REPAIR_BY_DATE,new SearchRepairByDate());

        return "home";
    }

    @RequestMapping(value= "/admin/home/search", method = RequestMethod.GET)
    public String searchByDate(Model model,@ModelAttribute(SEARCH_REPAIR_BY_DATE) SearchRepairByDate searchRepairByDate){


        repairs= repairService.searchByDate(toDate(searchRepairByDate.getDateStart()),toDate(searchRepairByDate.getDateEnd()));

        model.addAttribute("repairs",repairs);
        model.addAttribute(SEARCH_REPAIR_BY_DATE,new SearchRepairByDate());

        return "home";
    }



    private static Date toDate(String text){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = format.parse(text);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;


    }
}
