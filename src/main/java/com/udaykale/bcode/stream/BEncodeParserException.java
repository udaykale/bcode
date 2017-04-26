package com.udaykale.bcode.stream;


import com.udaykale.bcode.core.BEncodeException;

/**
 * @author uday
 */
public class BEncodeParserException extends BEncodeException {

    private final BEncodeLocation location;

    public BEncodeParserException(String message, BEncodeLocation location) {
        super(message);
        this.location = location;
    }

    public BEncodeParserException(String message, Throwable cause, BEncodeLocation location) {
        super(message, cause);
        this.location = location;
    }

    public BEncodeLocation getLocation() {
        return location;
    }
}
