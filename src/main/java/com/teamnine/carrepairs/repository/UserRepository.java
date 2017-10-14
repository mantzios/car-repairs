package com.teamnine.carrepairs.repository;

import com.teamnine.carrepairs.domain.Owner;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Owner,Long> {


    Owner findByEmailAndPassword(String email,String password);




}
