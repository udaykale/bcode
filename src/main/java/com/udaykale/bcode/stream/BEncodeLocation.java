package com.udaykale.bcode.stream;

/**
 * @author uday
 */
public interface BEncodeLocation {

    long getLineNumber();

    long getColumnNumber();

    long getStreamOffset();
}
