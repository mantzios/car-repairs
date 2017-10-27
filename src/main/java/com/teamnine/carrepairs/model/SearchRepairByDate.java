package com.teamnine.carrepairs.model;

import org.hibernate.validator.constraints.NotEmpty;

public class SearchRepairByDate {

    @NotEmpty(message = "{search.date.empty}")
    private String dateStart;
    @NotEmpty(message = "{search.date.empty}")
    private String dateEnd;

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
