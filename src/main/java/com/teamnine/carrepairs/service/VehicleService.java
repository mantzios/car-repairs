package com.teamnine.carrepairs.service;

import com.teamnine.carrepairs.domain.Vehicle;
import com.teamnine.carrepairs.model.VehicleForm;
import javafx.util.Pair;

import java.util.List;
import java.util.Set;

public interface VehicleService {

    Vehicle searchByPlate(String plate);

    Set<Vehicle> searchByOwnerAfm(int afm);

    List<Vehicle> findAll();

    void insertVehicle(VehicleForm vehicleForm);

    void editVehicle(VehicleForm vehicleForm);

    Vehicle findById(long id);

    List<Vehicle> searchVelicleByPlate(String searchText);

    List<Vehicle> searchVelicleByAfm(String searchText);


}
