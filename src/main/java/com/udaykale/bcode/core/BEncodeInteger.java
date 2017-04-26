package com.udaykale.bcode.core;

import java.math.BigInteger;

/**
 * @author uday
 */
public interface BEncodeInteger extends BEncodeValue {

    default int integerValue() {
        return bigIntegerValue().intValue();
    }

    default long longValue() {
        return bigIntegerValue().longValue();
    }

    BigInteger bigIntegerValue();
}
