package com.teamnine.carrepairs.converter;

import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.model.OwnerForm;
import com.teamnine.carrepairs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class OwnerConverter {

   @Autowired
   private AccountService accountService;

   public static Owner buildOwnerObject(OwnerForm ownerForm){
        Owner owner = new Owner();
        owner.setAccess(ownerForm.getAccess().toUpperCase());
        owner.setAfm(Integer.parseInt(ownerForm.getAfm()));
        owner.setEmail(ownerForm.getEmail());
        //owner.setOwnerid(Long.parseLong(ownerForm.getOwnerID()));
        owner.setLastname(ownerForm.getLastName());
        owner.setName(ownerForm.getFirstName());
        owner.setPassword(ownerForm.getPassword());
        return owner;
    }

    public static OwnerForm buildOwnerForm(Owner owner){
       OwnerForm ownerForm=new OwnerForm();
       ownerForm.setAccess(owner.getAccess());
       ownerForm.setAfm(Integer.toString(owner.getAfm()));
       ownerForm.setEmail(owner.getEmail());
       ownerForm.setFirstName(owner.getName());
       ownerForm.setLastName(owner.getLastname());
       ownerForm.setOwnerID(Long.toString(owner.getOwnerid()));
       return ownerForm;
    }
}
