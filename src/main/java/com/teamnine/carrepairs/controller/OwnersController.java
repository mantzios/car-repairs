package com.teamnine.carrepairs.controller;

import com.teamnine.carrepairs.converter.OwnerConverter;
import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.model.OwnerForm;
import com.teamnine.carrepairs.model.SearchFormOwner;
import com.teamnine.carrepairs.model.SearchFormRepair;
import com.teamnine.carrepairs.model.SearchOwnerForm;
import com.teamnine.carrepairs.service.AccountService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.*;


@Controller
public class OwnersController {

    @Autowired
    private AccountService accountService;

    private static final String OWNERS_LIST="owners";

    private static final String OWNER_FORM = "ownerForm";
    private static final String SEARCH_OWNER = "searchOwner";

    List<OwnerForm> ownerForms;
    Pair<List<OwnerForm>, String> pair;


    @RequestMapping(value= "/admin/owners", method = RequestMethod.GET)
    public String owners(Model model) {
        model.addAttribute(SEARCH_OWNER,new SearchOwnerForm());
        model.addAttribute(OWNERS_LIST,accountService.findAllOwners());
        return "owners";
    }

    @RequestMapping(value = "admin/owners/new",method = RequestMethod.GET)
    public String createOwner(Model model){
        model.addAttribute(OWNER_FORM,new OwnerForm());
        return "ownerForm";
    }

    @RequestMapping(value = "admin/owners/new",method = RequestMethod.POST)
    public String createOwner(Model model,@Valid @ModelAttribute(OWNER_FORM)
                            OwnerForm ownerForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            model.addAttribute(OWNER_FORM,ownerForm);
            return "ownerForm";
        }
        Owner owner = OwnerConverter.buildOwnerObject(ownerForm);
        accountService.insertUser(owner);
        return "redirect:/admin/owners";
    }

    /**
     * Edw prepei na mpei h methodos gia to delete..to url value="admin/owners/delete/{id}"
     */



    @RequestMapping(value = "admin/owners/edit", method = RequestMethod.GET)
    public String editOwner(Model model,@RequestParam(name = "id",required = true) long id){
        Owner owner=accountService.findUser(id);
        OwnerForm form=OwnerConverter.buildOwnerForm(owner);
        model.addAttribute(OWNER_FORM,form);
        return "editOwner";
    }

    @RequestMapping(value="admin/owners/edit",method = RequestMethod.POST)
    public String editOwner(@Valid @ModelAttribute(OWNER_FORM) OwnerForm ownerForm,BindingResult bindingResult,Model model,
                            @RequestParam(name = "id",required = true) long id){

        ownerForm.setOwnerID(String.valueOf(id));
        if (bindingResult.hasErrors()){
            model.addAttribute(OWNER_FORM,ownerForm);
            return "editOwner";
        }
        accountService.updateOwner(ownerForm);

        return "redirect:/admin/owners";
    }

    @RequestMapping(value = "admin/owners/search", method = RequestMethod.GET)
    public String search(Model model, @ModelAttribute(SEARCH_OWNER) SearchOwnerForm searchOwnerForm) {

         pair= accountService.searchOwnerBySearchText(searchOwnerForm.getSearchText().replaceAll(" ",""));

         model.addAttribute(OWNERS_LIST,pair.getKey());
         model.addAttribute(SEARCH_OWNER,new SearchOwnerForm());
         model.addAttribute("message", pair.getValue());

        return "owners";
    }




}
