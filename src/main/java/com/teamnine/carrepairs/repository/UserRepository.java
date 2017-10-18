package com.teamnine.carrepairs.repository;

import com.teamnine.carrepairs.domain.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Owner,Long> {


    Owner findByEmailAndPassword(String email,String password);





}
