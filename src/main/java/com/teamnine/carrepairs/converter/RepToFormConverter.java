package com.teamnine.carrepairs.converter;

import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.model.CreateRepairForm;
import com.teamnine.carrepairs.repository.UserRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RepToFormConverter {
    public static CreateRepairForm buildFormObject(Repair repair) {
       CreateRepairForm createRepairForm= new CreateRepairForm();
        Owner owner = new Owner();
        UserRepository userRepository;
        //  owner =userRepository.findOne(createRepairF)
        Date date= repair.getDatetime();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String stringDateTime = df.format(date);
        String[] parts = stringDateTime.split(" ");
        String stringDate = parts[0];
        String stringTime = parts[1];

        createRepairForm.setCost(repair.getCost());
        createRepairForm.setDatetime(stringDate);
        createRepairForm.setTextarea(repair.getTextarea());
        createRepairForm.setStatus(repair.getStatus());
        createRepairForm.setType(repair.getType());
        createRepairForm.setTime(stringTime);
        createRepairForm.setId_repair(String.valueOf(repair.getId()));



        return createRepairForm;
    }
}
