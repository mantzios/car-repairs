package com.teamnine.carrepairs.repository;

import com.teamnine.carrepairs.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,Long> {

    Vehicle findByPlate(String plate);
}
