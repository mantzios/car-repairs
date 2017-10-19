package com.teamnine.carrepairs.converter;


import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.model.CreateRepairForm;
import com.teamnine.carrepairs.repository.RepairRepository;
import com.teamnine.carrepairs.repository.UserRepository;
import com.teamnine.carrepairs.service.AccountService;
import com.teamnine.carrepairs.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RepairConverter {

    @Autowired
    private static AccountService accountService;


    public static Repair buildRepairObject(CreateRepairForm createRepairForm) {
        Repair repair = new Repair();
        Owner owner;
        long a=Long.parseLong(String.valueOf(createRepairForm.getAfm()));

        owner = accountService.findOwnerbyAFM(createRepairForm.getAfm());

        String dateString = createRepairForm.getDatetime().concat(" "+createRepairForm.getTime());


        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try{
        Date date = format.parse(dateString);
            repair.setDatetime(date);} catch (ParseException e) {
            e.printStackTrace();
        }


        repair.setCost(createRepairForm.getCost());
        repair.setStatus(createRepairForm.getStatus());
        repair.setType(createRepairForm.getType());
        repair.setTextarea(createRepairForm.getTextarea());
        repair.setOwner(owner);


        return repair;
    }
}
