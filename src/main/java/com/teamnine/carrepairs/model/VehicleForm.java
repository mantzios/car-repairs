package com.teamnine.carrepairs.model;

import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.domain.Vehicle;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.Set;

public class VehicleForm {

    private static final String VEHICLE_PATTERN="([A-Z])([A-Z])([A-Z])-\\d\\d\\d\\d";
    private static final String YEAR_PATTERN="\\d\\d\\d\\d";
    private static final String MODEL_PATTERN="^[a-zA-Z ]*$";
    private static final String AFM_PATTERN="\\d\\d\\d\\d\\d\\d\\d\\d\\d";


    private String vehicleID;

    @NotEmpty(message = "{vehicle.plate.empty}")
    @Pattern(regexp = VEHICLE_PATTERN,message = "{vehicle.invalid.plate}")
    private String plate;

    @NotEmpty(message = "{vehicle.year.empty}")
    @Pattern(regexp = YEAR_PATTERN,message = "{vehicle.invalid.year}")
    private String year;

    @NotEmpty(message = "{vehicle.model.empty}")
    @Pattern(regexp = MODEL_PATTERN,message = "{vehicle.invalid.model}")
    private String model;

    @NotEmpty(message = "{vehicle.model.empty}")
    @Pattern(regexp = MODEL_PATTERN,message = "{vehicle.invalid.model}")
    private String color;

    @NotEmpty(message = "{user.afm.empty}")
    @Pattern(regexp = AFM_PATTERN,message = "{user.invalid.afm}")
    private String ownerAfm;

    private Set<Repair> repairSet;

    public Set<Repair> getRepairSet() {
        return repairSet;
    }

    public void setRepairSet(Set<Repair> repairSet) {
        this.repairSet = repairSet;
    }

    public String getOwnerAfm() {
        return ownerAfm;
    }

    public void setOwnerAfm(String ownerAfm) {
        this.ownerAfm = ownerAfm;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
