package com.teamnine.carrepairs.controller;

import com.teamnine.carrepairs.converter.VehicleConverter;
import com.teamnine.carrepairs.domain.Vehicle;
import com.teamnine.carrepairs.model.OwnerForm;
import com.teamnine.carrepairs.model.VehicleForm;
import com.teamnine.carrepairs.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class VehicleController {

    private static final String VEHICLE_LIST="vehicles";
    private static final String VEHICLE_FORM="vehicleForm";

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/admin/vehicles",method = RequestMethod.GET)
    public String vehicleHome(Model model){
        model.addAttribute(VEHICLE_LIST,vehicleService.findAll());
        return "vehicle";
    }

    @RequestMapping(value="/admin/vehicles/new",method = RequestMethod.GET)
    public String addVehicle(Model model){
        model.addAttribute(VEHICLE_FORM,new VehicleForm());
        return "vehicleForm";
    }

    @RequestMapping(value="/admin/vehicles/new",method = RequestMethod.POST)
    public String addVehicle(Model model, @Valid @ModelAttribute(VEHICLE_FORM)
            VehicleForm vehicleForm, BindingResult bindingResult){

        vehicleService.insertVehicle(vehicleForm);
        return "redirect:/admin/vehicles";
    }

    @RequestMapping(value = "/admin/vehicles/edit",method = RequestMethod.GET)
    public String editVehicle(Model model,@RequestParam(name = "id",required = true) long id){
        Vehicle vehicle=vehicleService.findById(id);
        model.addAttribute(VEHICLE_FORM, VehicleConverter.buildVehicleForm(vehicle));
        return "editVehicle";
    }

    @RequestMapping(value="admin/vehicles/edit",method = RequestMethod.POST)
    public String editVehicle(@Valid @ModelAttribute(VEHICLE_FORM) VehicleForm vehicleForm,BindingResult bindingResult,Model model,
                            @RequestParam(name = "id",required = true) long id){

        vehicleForm.setVehicleID(String.valueOf(id));
        /*if (bindingResult.hasErrors()){
            model.addAttribute(OWNER_FORM,ownerForm);
            return "editOwner";
        }*/
        vehicleService.editVehicle(vehicleForm);

        return "redirect:/admin/owners";
    }
}
