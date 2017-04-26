package com.udaykale.bcode.stream;

/**
 * @author uday
 */
public enum BEncodeContextType {

    START_INTEGER, // i in ASCII

    START_STRING_SIZE, // an integer

    START_STRING, // : in ASCII

    START_LIST, // l in ASCII

    KEY_NAME, // key of dictionary

    START_DICTIONARY, // d in ASCII

    VALUE_INTEGER, // an integer

    VALUE_STRING, // a byte string

    END // e in ASCII
}
