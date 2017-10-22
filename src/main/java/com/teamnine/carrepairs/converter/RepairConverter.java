package com.teamnine.carrepairs.converter;


import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.domain.Vehicle;
import com.teamnine.carrepairs.model.CreateRepairForm;
import com.teamnine.carrepairs.repository.UserRepository;
import com.teamnine.carrepairs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RepairConverter {



    public static Repair buildRepairObject(CreateRepairForm createRepairForm,Owner owner,Vehicle vehicle) {

        Repair repair = new Repair();

        String dateString = createRepairForm.getDatetime().concat(" "+createRepairForm.getTime());


        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try{
        Date date = format.parse(dateString);
            repair.setDatetime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        repair.setCost(createRepairForm.getCost());
        repair.setStatus(createRepairForm.getStatus());
        repair.setType(createRepairForm.getType());
        repair.setTextarea(createRepairForm.getTextarea());
        repair.setOwner(owner);
        repair.setVehicle(vehicle);



        return repair;
    }
}
