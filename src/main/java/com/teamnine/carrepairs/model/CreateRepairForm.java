package com.teamnine.carrepairs.model;

import com.teamnine.carrepairs.domain.Repair;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class CreateRepairForm {

    private String datetime;

    private String status;

    private String type;

    private String cost;

    private String textarea;

    private String time;

  //  private String afm;

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

    /*  public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }*/
}
