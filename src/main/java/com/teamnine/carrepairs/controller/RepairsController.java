package com.teamnine.carrepairs.controller;

import com.teamnine.carrepairs.converter.RepairConverter;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.exception.UserNotFoundException;
import com.teamnine.carrepairs.model.CreateRepairForm;
import com.teamnine.carrepairs.model.EditRepairForm;
import com.teamnine.carrepairs.model.SearchFormRepair;
import com.teamnine.carrepairs.model.SearchRepairByDate;
import com.teamnine.carrepairs.repository.VehicleRepository;
import com.teamnine.carrepairs.service.AccountService;
import com.teamnine.carrepairs.service.RepairService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;


@Controller
public class RepairsController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static final String CREATE_FORM= "createRepairForm";
    private static final String USER_EXCEPTION="error";
    private static final String SEARCH_REPAIR = "searchForm";
    private static final String LIST_REPAIRS = "repairs";
    private static final String DELETE_EXCEPTION = "delete" ;
    private Set<Repair> repairSet;

    @Autowired
    private RepairService repairService;
    @Autowired
    private AccountService accountService;



    @Autowired
    private VehicleRepository vehicleRepository;

    @RequestMapping(value = "/admin/repairs", method = RequestMethod.GET)
    public String register(Model model) {
        CreateRepairForm createRepairForm = new CreateRepairForm();
        createRepairForm.setStatus("");
        model.addAttribute(CREATE_FORM, createRepairForm );
        return "repairs";

    }

    @RequestMapping(value = "/admin/repairs", method = RequestMethod.POST)
    public String register(Model model,@Valid @ModelAttribute(CREATE_FORM)
            CreateRepairForm createRepairForm,
                           BindingResult bindingResult, HttpSession session,
                           RedirectAttributes redirectAttributes) throws UserNotFoundException {
        long id;

        if (bindingResult.hasErrors()) {
            model.addAttribute(CREATE_FORM, createRepairForm);
            return "repairs";
        }
        Repair repair = RepairConverter.buildRepairObject(createRepairForm,
                accountService.findOwnerbyAFM(Long.parseLong(createRepairForm.getAfm())),
                vehicleRepository.findByPlate(createRepairForm.getPlate_num()));

        id = repairService.save(repair);
        redirectAttributes.addFlashAttribute("message", "Repair successfully added with id: " + id);
        return "redirect:/admin/home";
    }


    @RequestMapping(value = "admin/repairs/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable String id) {
        repairService.deleteRepair(Long.parseLong(id));
        return "redirect:/admin/home";
    }

    @RequestMapping(value = "admin/repairs/search", method = RequestMethod.GET)
    public String search(Model model, @ModelAttribute(SEARCH_REPAIR) SearchFormRepair searchFormRepair) {
        repairSet = new HashSet<>();
        model.addAttribute("searchRepairByDate",new SearchRepairByDate());
        if (searchFormRepair.getAfm() != null) {
            //call service to search by id
            try{
                repairSet.addAll(repairService.searchByAFM(Long.parseLong(searchFormRepair.getAfm())));
            }catch (Exception e){
                model.addAttribute("message","Please give a valid afm");
            }

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

    @ExceptionHandler(UserNotFoundException.class)
    public String OwnerException(Model model, HttpServletRequest request){
        //CreateRepairForm repairForm = (CreateRepairForm) request.getAttribute(CREATE_FORM);
        model.addAttribute(USER_EXCEPTION,"There is no user with this AFM");
        model.addAttribute(CREATE_FORM,new CreateRepairForm());
        return "repairs";
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String DeleteException(Model model, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute(DELETE_EXCEPTION,"You cannot delete this repair");
        return "redirect:/admin/home";
    }
}