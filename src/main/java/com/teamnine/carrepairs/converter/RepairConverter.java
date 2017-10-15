package com.teamnine.carrepairs.converter;


import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.model.CreateRepairForm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RepairConverter {

    public static Repair buildRepairObject(CreateRepairForm createRepairForm) {
        Repair repair = new Repair();
        String string = createRepairForm.getDatetime();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try{
        Date date = format.parse(string);
            repair.setDatetime(date);} catch (ParseException e) {
            e.printStackTrace();
        }


        repair.setCost(createRepairForm.getCost());
        repair.setStatus(createRepairForm.getStatus());
        repair.setType(createRepairForm.getType());
        repair.setTextarea(createRepairForm.getTextarea());
        return repair;
    }
}
