package com.teamnine.carrepairs.service;

import com.teamnine.carrepairs.Utilities.Utilities;
import com.teamnine.carrepairs.converter.OwnerConverter;
import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.domain.Vehicle;
import com.teamnine.carrepairs.exception.LoginException;
import com.teamnine.carrepairs.exception.UserNotFoundException;
import com.teamnine.carrepairs.model.OwnerForm;
import com.teamnine.carrepairs.repository.UserRepository;
import com.teamnine.carrepairs.repository.VehicleRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private RepairService repairService;

    @Override
    public Owner login(String email, String password) throws AuthenticationException {
        Owner owner=userRepository.findByEmailAndPassword(email,password);
        if (owner == null) {
            throw new LoginException("Error credentials");
        }
        return owner;
    }

    @Override
    public Owner findOwnerbyAFM(long afm) throws UserNotFoundException {
        Owner owner=userRepository.findOwnerByAFM(afm);
        if (owner == null) {
            throw new UserNotFoundException("user not found");
        }
        return owner;
    }
    @Override
    public Owner findOwnerbyEmail(String email) throws UserNotFoundException{
        Owner owner = userRepository.findByEmail(email);
        if (owner == null) {
            throw new UserNotFoundException("user not found");
        }
        return owner;
    }

    @Override
    public List<OwnerForm> findAllOwners() {
        List<Owner> list=userRepository.findAll();
        List<OwnerForm> ownerList=new ArrayList<>();
        for(Owner owner:list){
            ownerList.add(OwnerConverter.buildOwnerForm(owner));
        }
        return ownerList;
    }

    @Override
    public void insertUser(Owner owner) {
        userRepository.save(owner);
    }

    @Override
    public Owner findUser(long id) throws UserNotFoundException {
        Owner owner = userRepository.findByOwnerid(id);
        if (owner == null) {
            throw new UserNotFoundException("user not found");
        }
        return owner;
    }

    @Override
    public void updateOwner(OwnerForm ownerForm) {
        Owner owner= OwnerConverter.buildOwnerObject(ownerForm);
        List<Repair> repairList=repairService.searchByAFM(Long.parseLong(ownerForm.getAfm()));
        Set<Vehicle> vehicleList=vehicleRepository.findByOwnerAfm(Integer.parseInt(ownerForm.getAfm()));
        if(repairList == null){
            repairList=new ArrayList<>();
        }
        if(vehicleList == null){
            vehicleList=new HashSet<>();
        }
        owner.setRepair(new HashSet<>(repairList));
        owner.setVehicle(vehicleList);
        userRepository.save(owner);
    }

    public List<OwnerForm> searchOwnerByEmail(String searchText){
        List<OwnerForm> ownerForms= new ArrayList<>();
        try {
            Owner owner = findOwnerbyEmail( searchText);
            ownerForms.add(OwnerConverter.buildOwnerForm(owner));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return ownerForms;
    }

    public List<OwnerForm> searchOwnerByAfm(Long searchText){
        List<OwnerForm> ownerForms= new ArrayList<>();
        try {
            Owner owner = findOwnerbyAFM(searchText);
            ownerForms.add(OwnerConverter.buildOwnerForm(owner));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return ownerForms;

    }

    @Override
    public void deleteOwner(long id) {
        userRepository.delete(id);
    }

}
