package com.teamnine.carrepairs.service;

import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RepairServiceImpl implements RepairService{
    @Autowired
    private RepairRepository repairRepository;


    @Override
    public List<Repair> findAllRepairs() {
        return repairRepository.findAll();
    }
}
