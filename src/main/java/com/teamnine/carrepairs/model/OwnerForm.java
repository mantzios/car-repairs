package com.teamnine.carrepairs.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class OwnerForm {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";

    private static final String CHARACTERS_PATTERN = "^[a-zA-Z ]*$";

    private static final String MAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";

    private static final int PASSWORD_MINSIZE = 6;

    private static final String ACCESS_PATTERN="(?:user|admin|USER|ADMIN)";

    private static final String AFM_NUMBER="\\d\\d\\d\\d\\d\\d\\d\\d\\d";
    private String ownerID;

    @NotEmpty(message = "{user.afm.empty}")
    @Pattern(regexp = AFM_NUMBER, message = "{user.invalid.afm}")
    private String afm;

    @NotEmpty(message = "{user.name.empty}")
    @Pattern(regexp = CHARACTERS_PATTERN, message = "{user.invalid.name}")
    private String firstName;

    @NotEmpty(message = "{user.name.empty}")
    @Pattern(regexp = CHARACTERS_PATTERN, message = "{user.invalid.name}")
    private String lastName;

    @NotEmpty(message = "{user.email.empty}")
    @Pattern(regexp = MAIL_PATTERN, message = "{user.invalid.email}")
    private String email;

    @NotEmpty(message = "{user.access.empty}")
    @Pattern(regexp = ACCESS_PATTERN, message = "{user.invalid.access}")
    private String access;

    @NotEmpty(message = "{user.password.empty}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{user.invalid.password}")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String acess) {
        this.access = acess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnerForm ownerForm = (OwnerForm) o;

        return afm.equals(ownerForm.afm);
    }

    @Override
    public int hashCode() {
        return afm.hashCode();
    }
}
