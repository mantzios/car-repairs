package com.teamnine.carrepairs.domain;

import com.sun.org.apache.regexp.internal.RE;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner implements Serializable {

    @Id
    @Column(name = "Owner_id", nullable =false)
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long ownerid;

    @Column(name = "afm_number", nullable =false)
    private int afm;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email",nullable =false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "access",nullable = false)
    private String access;


    @OneToMany(mappedBy = "owner",targetEntity = Vehicle.class,cascade =CascadeType.REMOVE,orphanRemoval = true)
    private Set<Vehicle> vehicle;


    @OneToMany(mappedBy = "owner",targetEntity = Repair.class)
    private Set<Repair> repair;

    public Set<Repair> getRepair() {
        return repair;
    }

    public void setRepair(Set<Repair> repair) {
        this.repair = repair;
    }

    public Set<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Set<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }



    public long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }

    public int getAfm() {
        return afm;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}

