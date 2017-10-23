package com.teamnine.carrepairs.service;

import com.teamnine.carrepairs.domain.Vehicle;
import com.teamnine.carrepairs.exception.UserNotFoundException;
import com.teamnine.carrepairs.exception.VehicleNotFoundException;
import com.teamnine.carrepairs.model.VehicleForm;
import javafx.util.Pair;

import java.util.List;
import java.util.Set;

public interface VehicleService {

    Vehicle searchByPlate(String plate);

    Set<Vehicle> searchByOwnerAfm(int afm);

    List<Vehicle> findAll();

    void insertVehicle(VehicleForm vehicleForm) throws UserNotFoundException;

    void editVehicle(VehicleForm vehicleForm);

    Vehicle findById(long id) throws VehicleNotFoundException;

    List<Vehicle> searchVelicleByPlate(String searchText);

    List<Vehicle> searchVelicleByAfm(String searchText);


}
