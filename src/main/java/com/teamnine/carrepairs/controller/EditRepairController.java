package com.teamnine.carrepairs.controller;

import com.teamnine.carrepairs.converter.RepToFormConverter;
import com.teamnine.carrepairs.converter.RepairConverterEdit;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.exception.RepairNotFoundException;
import com.teamnine.carrepairs.model.EditRepairForm;
import com.teamnine.carrepairs.service.RepairService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EditRepairController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static final String FORM = "editRepairForm";

    private static final String ERROR="error";

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/admin/edit/repair", method = RequestMethod.GET)
    public String register(Model model, @RequestParam(name = "id", required = true) long id, RedirectAttributes redirect) throws RepairNotFoundException {
        Repair repair = repairService.findById(id);


        EditRepairForm editRepairForm = RepToFormConverter.buildFormObject(repairService.findById(id));

        model.addAttribute(FORM, new EditRepairForm());
        model.addAttribute("repair", editRepairForm);

        return "editRepair";

    }


    @RequestMapping(value = "/admin/edit/repair", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute(FORM) EditRepairForm editRepairForm,
                           Model model,
                           @RequestParam(name = "id", required = true) long id) throws RepairNotFoundException {

        Repair repair = RepairConverterEdit.buildRepairObject(editRepairForm);
        repair.setId(id);
        Repair temp = repairService.findById(id);
        System.out.println();
        //repair.setDatetime(new Date());
        repair.setOwner(temp.getOwner());
        repair.setVehicle(temp.getVehicle());
        repairService.updateRepair(repair);

        return "redirect:/admin/home";
    }


    @ExceptionHandler(RepairNotFoundException.class)
    public String ErrorHandling(Model model){
        model.addAttribute(ERROR,"Repair not found");
        return "editRepair";
    }

}


