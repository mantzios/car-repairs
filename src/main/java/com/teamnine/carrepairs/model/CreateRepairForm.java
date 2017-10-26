package com.teamnine.carrepairs.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class CreateRepairForm {

    private static final String COST="\\d+.*| \\.\\d+";
    private static final String AFM_NUMBER="\\d\\d\\d\\d\\d\\d\\d\\d\\d";
   // private static final String STATUS="(?:New|In Progress..)";
    private static final String PLATE="([A-Z])([A-Z])([A-Z])-\\d\\d\\d\\d";

    @NotEmpty(message = "{repair.datetime.empty}")
    private String datetime;

    @NotEmpty(message = "{repair.status.empty}")
   // @Pattern(regexp = STATUS, message = "{repair.invalid.status}")
    private String status;

    @NotEmpty(message = "{repair.type.empty}")
    private String type;

    @NotEmpty(message = "{repair.cost.empty}")
    @Pattern(regexp = COST, message = "{repair.invalid.cost}")
    private String cost;

    private String textarea;
    @NotEmpty(message = "{repair.time.empty}")
    private String time;

    @NotEmpty(message = "{repair.afm.empty}")
    @Pattern(regexp = AFM_NUMBER, message = "{repair.invalid.afm}")
    private String afm;

    @NotEmpty(message = "{repair.plate.empty}")
    @Pattern(regexp = PLATE, message = "{repair.invalid.plate}")
    private String plate_num;

    private String id_repair;

    public CreateRepairForm() {
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
