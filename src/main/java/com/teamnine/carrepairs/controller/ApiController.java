package com.teamnine.carrepairs.controller;

import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.exception.UserNotFoundException;
import com.teamnine.carrepairs.exception.VehicleNotFoundException;
import com.teamnine.carrepairs.service.AccountService;
import com.teamnine.carrepairs.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/admin/api/afm/{afm}",method = RequestMethod.GET)
    public ResponseEntity checkUser(@PathVariable long afm){
        try {
            Owner owner = accountService.findOwnerbyAFM(afm);
        } catch (UserNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity<Integer>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/api/plate/{plate}", method = RequestMethod.GET)
    public ResponseEntity checkVehicle(@PathVariable String plate){
        try {
            vehicleService.searchByPlate(plate);
        } catch (VehicleNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND) ;

        }
        return new ResponseEntity<Integer>(HttpStatus.OK);
    }
}
