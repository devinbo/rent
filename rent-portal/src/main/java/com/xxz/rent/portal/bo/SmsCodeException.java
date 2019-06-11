package com.xxz.rent.portal.bo;

import org.springframework.security.core.AuthenticationException;

public class SmsCodeException extends AuthenticationException {


    public SmsCodeException(String message) {
        super(message);
    }

    public SmsCodeException(String message, Throwable cause) {
        super(message, cause);
    }

}
