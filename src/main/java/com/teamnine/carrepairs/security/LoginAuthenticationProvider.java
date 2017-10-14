package com.teamnine.carrepairs.security;

import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.repository.UserRepository;
import com.teamnine.carrepairs.service.AccountService;
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

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        System.out.println(authentication.getName());
        Owner user=userRepository.findByEmail(authentication.getName());
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getAccess()));
        return new UsernamePasswordAuthenticationToken(user.getEmail(),"fdfd",grantedAuthorities);

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}