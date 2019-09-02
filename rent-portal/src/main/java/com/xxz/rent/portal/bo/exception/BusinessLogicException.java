package com.xxz.rent.portal.bo.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BusinessLogicException extends RuntimeException{

    public BusinessLogicException() {
    }

    public BusinessLogicException(String message) {
        super(message);
        log.error(message);
    }

    public BusinessLogicException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public BusinessLogicException(Throwable cause) {
        super(cause);
        log.error(cause.getMessage(), cause);
    }

    public BusinessLogicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(cause.getMessage(), cause);
    }
}
