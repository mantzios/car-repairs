package com.teamnine.carrepairs.service;

import com.teamnine.carrepairs.domain.Owner;
import org.springframework.security.core.AuthenticationException;

public interface AccountService {
    Owner login(String username, String password) throws AuthenticationException;
}
