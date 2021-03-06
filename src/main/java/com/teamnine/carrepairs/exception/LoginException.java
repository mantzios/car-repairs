package com.teamnine.carrepairs.exception;

import org.springframework.security.core.AuthenticationException;

public class LoginException extends AuthenticationException {
    public LoginException(String msg, Throwable t) {
        super(msg, t);
    }

    public LoginException(String msg) {
        super(msg);
    }
}
