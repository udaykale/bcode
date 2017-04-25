package com.udaykale.bcode;

/**
 * @author uday
 */
public class BEncodeException extends RuntimeException {

    BEncodeException(String message) {
        super(message);
    }

    BEncodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
