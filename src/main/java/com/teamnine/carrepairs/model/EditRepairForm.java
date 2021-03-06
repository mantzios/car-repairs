package com.teamnine.carrepairs.model;

import com.teamnine.carrepairs.domain.Repair;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class EditRepairForm {

    private static final String COST="\\d+.*| \\.\\d+";
    private static final String AFM_NUMBER="\\d\\d\\d\\d\\d\\d\\d\\d\\d";
    private static final String PLATE="([A-Z])([A-Z])([A-Z])-\\d\\d\\d\\d";

    private String owner_id;

    private String vehicle_id;

    @NotEmpty(message = "{repair.datetime.empty}")
    private String datetime;

    @NotEmpty(message = "{repair.status.empty}")
    private String status;

    @NotEmpty(message = "{repair.type.empty}")
    private String type;

    @NotEmpty(message = "{repair.cost.empty}")
    @Pattern(regexp = COST, message = "{repair.invalid.cost}")
    private String cost;

    private String textarea;

    @NotEmpty(message = "{repair.time.empty}")
    private String time;

    private String afm;


    private String plate_num;

     private String id_repair;

    public EditRepairForm() {
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTextarea() {
        return textarea;
    }

    public void setTextarea(String textarea) {
        this.textarea = textarea;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

      public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getPlate_num() {
        return plate_num;
    }

    public void setPlate_num(String plate_num) {
        this.plate_num = plate_num;
    }

    public String getId_repair() {
        return id_repair;
    }

    public void setId_repair(String id_repair) {
        this.id_repair = id_repair;
    }
}
