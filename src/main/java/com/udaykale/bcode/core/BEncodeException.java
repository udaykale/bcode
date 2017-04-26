package com.udaykale.bcode.core;

/**
 * @author uday
 */
public class BEncodeException extends RuntimeException {

    public BEncodeException(String message) {
        super(message);
    }

    public BEncodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
