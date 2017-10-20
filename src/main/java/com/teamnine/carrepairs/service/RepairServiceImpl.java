package com.teamnine.carrepairs.service;

import com.teamnine.carrepairs.Utilities.Utilities;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairRepository repairRepository;

    @Override
    public List<Repair> findAllRepairs() {
        return repairRepository.findAll();
    }

    @Override
    public long save(Repair repair) {


       Repair r = repairRepository.save(repair);
       return r.getId();
    }
    @Override
    public Repair findById(Long id) {
        return  repairRepository.findOne(id);

    }

    @Override
    public void deleteRepair(Long id) {
        repairRepository.delete(id);
    }

    @Override
    public List<Repair> searchByVehiclePlate(String vehiclePlate) {
        return repairRepository.findRepairByVehiclePlate(vehiclePlate);
    }

    @Override
    public List<Repair> searchByAFM(long afm) {
        return repairRepository.findRepairByOwnerAFM(afm);
    }

    @Override
    public List<Repair> searchByDate(Date start, Date end) {
        Date startDate=Utilities.setStartDate(start);
        Date endDate=Utilities.setEndDate(end);
        return repairRepository.findAllByDatetimeBetween(startDate,endDate);
    }

    @Override
    public List<Repair> searchByDate(Date date) {
        Date startDate=Utilities.setStartDate(date);
        Date endDate=Utilities.setEndDate(date);
        return repairRepository.findAllByDatetimeBetween(startDate,endDate);
    }

    @Override
    public void updateRepair(Repair repair) {
        repairRepository.save(repair);
    }
}
