package com.teamnine.carrepairs.controller;

import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.exception.UserNotFoundException;
import com.teamnine.carrepairs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/admin/api/{id}",method = RequestMethod.GET)
    public @ResponseBody int checkUser(@PathVariable long id){
        try {
            Owner owner = accountService.findUser(id);
        } catch (UserNotFoundException e) {
            return -1;
        }
        return 1;
    }
}
