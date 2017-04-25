package com.udaykale.bcode;

import java.math.BigInteger;

/**
 * @author uday
 */
public interface BEncodeInteger extends BEncodeValue {

    int integerValue();

    long longValue();

    BigInteger bigIntegerValue();
}
