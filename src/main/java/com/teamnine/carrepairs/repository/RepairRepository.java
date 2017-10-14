package com.teamnine.carrepairs.repository;

import com.teamnine.carrepairs.domain.Repair;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepairRepository extends CrudRepository<Repair,Long> {
    List<Repair> findAll();

}
