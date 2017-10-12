package com.teamnine.carrepairs.service;

import org.springframework.security.core.AuthenticationException;

public interface AccountService {
    void login(String username, String password) throws AuthenticationException;
}
