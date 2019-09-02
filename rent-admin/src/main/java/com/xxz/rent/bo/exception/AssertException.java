package com.xxz.rent.bo.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssertException extends RuntimeException{

    public AssertException() {
    }

    public AssertException(String message) {
        super(message);
        log.error(message);
    }

    public AssertException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public AssertException(Throwable cause) {
        super(cause);
        log.error(cause.getMessage(), cause);
    }

    public AssertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(cause.getMessage(), cause);
    }
}
