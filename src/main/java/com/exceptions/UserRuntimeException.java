package com.exceptions;

/**
 * Created by Oleksandr on 11/8/2016.
 */
public class UserRuntimeException extends RuntimeException {

    public UserRuntimeException(String message) {
        super(message);
    }

    public UserRuntimeException(Throwable cause) {
        super(cause);
    }
}
