package com.teamnine.carrepairs.converter;


import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.model.CreateRepairForm;
import com.teamnine.carrepairs.repository.UserRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RepairConverter {

    public static Repair buildRepairObject(CreateRepairForm createRepairForm) {
        Repair repair = new Repair();
        Owner owner = new Owner();
        UserRepository userRepository;
      //  owner =userRepository.findOne(createRepairF)
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

        //owner_id apo tin createRepairForm
        //Owner service findOne
        // set ton owner pou vrethike
        //repair.setOwner(owner );
        return repair;
    }
}
