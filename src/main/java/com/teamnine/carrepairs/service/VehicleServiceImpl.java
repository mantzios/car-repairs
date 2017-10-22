package com.teamnine.carrepairs.service;

import com.teamnine.carrepairs.converter.VehicleConverter;
import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.domain.Vehicle;
import com.teamnine.carrepairs.model.VehicleForm;
import com.teamnine.carrepairs.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public Vehicle searchByPlate(String plate) {
        return vehicleRepository.findByPlate(plate);
    }

    @Override
    public Set<Vehicle> searchByOwnerAfm(int afm) {
        return vehicleRepository.findByOwnerAfm(afm);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public void insertVehicle(VehicleForm vehicleForm) {
        Vehicle vehicle= VehicleConverter.buildVehicle(vehicleForm);
        Owner owner= accountService.findOwnerbyAFM(Long.parseLong(vehicleForm.getOwnerAfm()));
        //throws exception
        vehicle.setOwner(owner);
        vehicleRepository.save(vehicle);
    }

    @Override
    public void editVehicle(VehicleForm vehicleForm) {
        Vehicle vehicle=VehicleConverter.buildVehicle(vehicleForm);
        Vehicle persistVehicle=vehicleRepository.findById(vehicle.getId());
        vehicle.setOwner(persistVehicle.getOwner());
        vehicle.setRepairs(persistVehicle.getRepairs());
        vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle findById(long id) {
        return vehicleRepository.findById(id);
    }
}
