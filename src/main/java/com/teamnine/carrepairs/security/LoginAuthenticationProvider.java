package com.teamnine.carrepairs.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        /*
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        accountService.login(username, password);
        return new UsernamePasswordAuthenticationToken(username, password);
        */

        //Owner owner = ownerRepository.findByEmail(email);
        // accountService.login("a","a");
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        String email="apo.mantzios";
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        //here we call the service for checking the role and the type of the user
        return new UsernamePasswordAuthenticationToken(email,"fdfd",grantedAuthorities);

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}