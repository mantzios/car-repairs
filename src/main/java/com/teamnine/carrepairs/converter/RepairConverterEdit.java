package com.teamnine.carrepairs.converter;

import com.teamnine.carrepairs.domain.Repair;

import com.teamnine.carrepairs.model.EditRepairForm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RepairConverterEdit {


    public static Repair buildRepairObject(EditRepairForm editRepairForm) {

        Repair repair = new Repair();

        String dateString = editRepairForm.getDatetime().concat(" "+editRepairForm.getTime());


        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try{
            Date date = format.parse(dateString);
            repair.setDatetime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        repair.setCost(editRepairForm.getCost());
        repair.setStatus(editRepairForm.getStatus());
        repair.setType(editRepairForm.getType());
        repair.setTextarea(editRepairForm.getTextarea());




        return repair;
    }



}
