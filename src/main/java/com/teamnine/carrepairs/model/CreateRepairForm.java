package com.teamnine.carrepairs.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class CreateRepairForm {
  /*  private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";



    private static final String MAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";

    private static final int PASSWORD_MINSIZE = 6;
*/private static final String CHARACTERS_PATTERN = "^[a-zA-Z ]*$";
    @Pattern(regexp = CHARACTERS_PATTERN, message = "{register.firstname.invalid}")
    private Date datetime;

    private String status;

    private String type;

    private String cost;

    private String textarea;

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
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
}
