package com.teamnine.carrepairs.converter;

import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.model.EditRepairForm;
import com.teamnine.carrepairs.repository.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RepToFormConverter {
    public static EditRepairForm buildFormObject(Repair repair) {
       EditRepairForm editRepairForm = new EditRepairForm();
        Owner owner = new Owner();

        Date date= repair.getDatetime();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String stringDateTime = df.format(date);
        String[] parts = stringDateTime.split(" ");
        String stringDate = parts[0];
        String stringTime = parts[1];

        editRepairForm.setCost(repair.getCost());
        editRepairForm.setDatetime(stringDate);
        editRepairForm.setTextarea(repair.getTextarea());
        editRepairForm.setStatus(repair.getStatus());
        editRepairForm.setType(repair.getType());
        editRepairForm.setTime(stringTime);
        editRepairForm.setId_repair(String.valueOf(repair.getId()));



        return editRepairForm;
    }
}
