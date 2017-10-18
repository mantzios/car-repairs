package com.teamnine.carrepairs.service;

import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.exception.LoginException;
import com.teamnine.carrepairs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Owner login(String email, String password) throws AuthenticationException {
        Owner owner=userRepository.findByEmailAndPassword(email,password);
        if (owner == null) {
            throw new LoginException("Error credentials");
        }
        return owner;
    }

    @Override
    public Owner findOwnerbyAFM(long afm) {
        return userRepository.findOwnerByAFM(afm);
    }

}
