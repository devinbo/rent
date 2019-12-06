package com.xxz.rent.portal.bo.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xxz
 */
@Slf4j
public class NoLoginException extends RuntimeException{

    public NoLoginException() {
    }

    public NoLoginException(String message) {
        super(message);
        log.error(message);
    }

    public NoLoginException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public NoLoginException(Throwable cause) {
        super(cause);
        log.error(cause.getMessage(), cause);
    }

    public NoLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(cause.getMessage(), cause);
    }
}
