package com.teamnine.carrepairs.repository;

import com.teamnine.carrepairs.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User,Long> {


    User findByEmail(String email);

    @Override
    void delete(User user);


}
