package com.teamnine.carrepairs.controller;

import com.teamnine.carrepairs.converter.RepairConverter;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.model.CreateRepairForm;
import com.teamnine.carrepairs.model.SearchFormRepair;
import com.teamnine.carrepairs.service.RepairService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;


@Controller
public class RepairsController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static final String FORM = "createRepairForm";

    private static final String SEARCH_REPAIR = "searchForm";
    private static final String LIST_REPAIRS = "repairs";

    Set<Repair> repairSet;

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/admin/repairs", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute(FORM, new CreateRepairForm());
        return "repairs";

    }


    @RequestMapping(value = "/admin/repairs", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute(FORM)
                                   CreateRepairForm createRepairForm,
                           BindingResult bindingResult, HttpSession session,
                           RedirectAttributes redirectAttributes) {
        long id;

        if (bindingResult.hasErrors()) {
            //have some error handling here, perhaps add extra error messages to the model
            //for now we're going to return a view ( register) but normally we would redirect to the
            //get method after adding the binding result and the form to the redirect attributes.
            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            return "repairs";
        }

        try {
            Repair repair = RepairConverter.buildRepairObject(createRepairForm);
            id = repairService.save(repair);

        } catch (Exception exception) {
            //if an error occurs show it to the user
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            return "redirect:/admin/repairs";
        }
        redirectAttributes.addFlashAttribute("message", "Repair successfully added with id: " + id);
        return "redirect:/admin/repairs";
    }


    @RequestMapping(value = "admin/repairs/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable String id) {
        repairService.deleteRepair(Long.parseLong(id));
        return "redirect:/admin/home";
    }

    @RequestMapping(value = "admin/repairs/search", method = RequestMethod.GET)
    public String search(Model model, @ModelAttribute(SEARCH_REPAIR) SearchFormRepair searchFormRepair) {
        repairSet = new HashSet<>();
        if (searchFormRepair.getAfm() != 0) {
            //call service to search by id
            repairSet.addAll(repairService.searchByAFM(searchFormRepair.getAfm()));
        }
        if (searchFormRepair.getVehiclePlate() != null) {
            // call service to search  by vehicle plate
            repairSet.addAll(repairService.searchByVehiclePlate(searchFormRepair.getVehiclePlate()));
        }
        /*
        repairSet.addAll(repairService.searchByDate(new Date(),calendar.getTime()));
        */
        repairService.searchByDate(new Date());
        model.addAttribute(LIST_REPAIRS, repairSet);
        return "home";
    }


}
