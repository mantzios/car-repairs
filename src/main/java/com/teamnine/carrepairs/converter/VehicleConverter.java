package com.teamnine.carrepairs.converter;

import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.domain.Vehicle;
import com.teamnine.carrepairs.model.VehicleForm;

import java.util.HashSet;
import java.util.Set;

public class VehicleConverter {

    public static Vehicle buildVehicle(VehicleForm vehicleForm){
        Vehicle vehicle = new Vehicle();
        vehicle.setColor(vehicleForm.getColor().toLowerCase());
        vehicle.setModel(vehicleForm.getModel().toLowerCase());
        vehicle.setPlate(vehicleForm.getPlate());
        if(vehicleForm.getVehicleID()!=null){
            vehicle.setId(Long.parseLong(vehicleForm.getVehicleID()));
        }
        if (vehicleForm.getRepairSet()!=null){
            Set<Repair> repairSet= new HashSet<>();
            vehicle.setRepairs(repairSet);
        }
        vehicle.setYear(vehicleForm.getYear());
        return vehicle;
    }

    public static VehicleForm buildVehicleForm(Vehicle vehicle){
        VehicleForm vehicleForm = new VehicleForm();
        vehicleForm.setVehicleID(String.valueOf(vehicle.getId()));
        vehicleForm.setColor(vehicle.getColor());
        vehicleForm.setModel(vehicle.getModel());
        vehicleForm.setPlate(vehicle.getPlate());
        vehicleForm.setYear(vehicle.getYear());
        return vehicleForm;
    }
}
