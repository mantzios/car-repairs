package com.teamnine.carrepairs.repository;

import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.model.OwnerForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Owner,Long> {

    List<Owner> findAll();

    Owner findByEmailAndPassword(String email,String password);

    @Query(value = "select * from owners  where  afm_number=:afm",nativeQuery = true)
    Owner findOwnerByAFM(@Param("afm")long afm);

    Owner findByOwnerid(long ownerID);




}
