package com.teamnine.carrepairs.repository;

import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.domain.Repair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<Owner,Long> {


    Owner findByEmailAndPassword(String email,String password);

    @Query(value = "select * from owners  where  afm_number=:afm",nativeQuery = true)
    Owner findOwnerByAFM(@Param("afm")long afm);



}
