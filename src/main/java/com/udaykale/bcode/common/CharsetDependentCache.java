package com.udaykale.bcode.common;

import java.nio.charset.Charset;

/**
 * @author uday
 */
public final class CharsetDependentCache {

    public final Charset CHARSET;

    public final int COLON;
    public final int INTEGER;
    public final int DICTIONARY;
    public final int LIST;
    public final int END;

    public final int ZERO;
    public final int ONE;
    public final int TWO;
    public final int THREE;
    public final int FOUR;
    public final int FIVE;
    public final int SIX;
    public final int SEVEN;
    public final int EIGHT;
    public final int NINE;

    public CharsetDependentCache(Charset _charset) {

        CHARSET = _charset;

        COLON = ":".getBytes(_charset)[0];
        INTEGER = "i".getBytes(_charset)[0];
        DICTIONARY = "d".getBytes(_charset)[0];
        LIST = "l".getBytes(_charset)[0];
        END = "e".getBytes(_charset)[0];

        ZERO = "0".getBytes(_charset)[0];
        ONE = "1".getBytes(_charset)[0];
        TWO = "2".getBytes(_charset)[0];
        THREE = "3".getBytes(_charset)[0];
        FOUR = "4".getBytes(_charset)[0];
        FIVE = "5".getBytes(_charset)[0];
        SIX = "6".getBytes(_charset)[0];
        SEVEN = "7".getBytes(_charset)[0];
        EIGHT = "8".getBytes(_charset)[0];
        NINE = "9".getBytes(_charset)[0];
    }
}
