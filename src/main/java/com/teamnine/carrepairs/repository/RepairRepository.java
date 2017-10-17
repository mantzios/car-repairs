package com.teamnine.carrepairs.repository;

import com.teamnine.carrepairs.domain.Repair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public interface RepairRepository extends CrudRepository<Repair,Long>{
    List<Repair> findAll();

    @Query(value = "select * from repair INNER JOIN vehicle ON repair.vehicle_id=vehicle.vehicle_id where  plate=:vehiclePlate",nativeQuery = true)
    List<Repair> findRepairByVehiclePlate(@Param("vehiclePlate") String vehiclePlate);

    @Query(value = "select * from repair INNER JOIN owners ON repair.owner_id=owners.owner_id where  afm_number=:afm",nativeQuery = true)
    List<Repair> findRepairByOwnerAFM(@Param("afm")long afm);

    List<Repair> findAllByDatetimeBetween(Date start,Date end);
}
