package com.udaykale.bcode.stream;

import com.udaykale.bcode.core.BEncodeString;

import java.io.Closeable;
import java.math.BigInteger;
import java.util.Iterator;

/**
 * @author uday
 */
public interface BEncodeParser extends Closeable, Iterator<BEncodeContextType> {

    BEncodeString getStringValue();

    default int getIntegerValue() {
        return getBigIntegerValue().intValue();
    }

    default long getLongValue() {
        return getBigIntegerValue().longValue();
    }

    BigInteger getBigIntegerValue();

    BEncodeLocation getLocation();

    @Override
    boolean hasNext();

    @Override
    BEncodeContextType next();

    @Override
    void close();
}
