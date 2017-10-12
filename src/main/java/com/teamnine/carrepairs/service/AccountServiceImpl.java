package com.teamnine.carrepairs.service;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Override
    public void login(String username, String password) throws AuthenticationException {

    }
}
