package com.teamnine.carrepairs.controller;

import com.teamnine.carrepairs.converter.RepToFormConverter;
import com.teamnine.carrepairs.converter.RepairConverter;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.model.CreateRepairForm;
import com.teamnine.carrepairs.service.RepairService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class EditRepairController {

        private  final static org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);
        private static final String FORM = "editRepairForm";

        @Autowired
        private RepairService repairService;

        @RequestMapping(value = "/admin/edit/repair", method = RequestMethod.GET)
        public String register(Model model, @RequestParam(name = "id", required = true) long id) {
            CreateRepairForm createRepairForm= RepToFormConverter.buildFormObject(repairService.findById(id));

            model.addAttribute(FORM, new CreateRepairForm());
            model.addAttribute("repair", createRepairForm);
            return "editRepair";

        }



     @RequestMapping(value = "/admin/edit/repair", method = RequestMethod.POST)
        public String register(@Valid @ModelAttribute(FORM) CreateRepairForm createRepairForm,
                               Model model,
                               @RequestParam(name = "id", required = true) long id)
     {

         Repair repair = RepairConverter.buildRepairObject(createRepairForm);
         repair.setId(id);
         Repair temp=repairService.findById(id);
         System.out.println();
         repair.setDatetime(new Date());
         repair.setOwner(temp.getOwner());
         repair.setVehicle(temp.getVehicle());
         repairService.updateRepair(repair);

             /*
                //if an error occurs show it to the user
                redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
                logger.error("User registration failed: " + exception);
                return "redirect:/admin/home";*/


         //redirectAttributes.addFlashAttribute("message", "Repair successfully updated with id: ");
         return "redirect:/admin/home";
        }
    }


