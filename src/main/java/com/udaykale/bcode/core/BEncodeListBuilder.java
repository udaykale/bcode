package com.udaykale.bcode.core;

import java.math.BigInteger;

/**
 * @author uday
 */
public interface BEncodeListBuilder {

    BEncodeListBuilder add(BEncodeValue value);

    default BEncodeListBuilder add(BEncodeString value) {
        return add(value.getByteSequence());
    }

    default BEncodeListBuilder add(BEncodeInteger value) {
        return add(value.bigIntegerValue());
    }

    BEncodeListBuilder add(BigInteger value);

    BEncodeListBuilder add(byte[] value);

    default BEncodeListBuilder add(int value) {
        return add(BigInteger.valueOf(value));
    }

    default BEncodeListBuilder add(long value) {
        return add(BigInteger.valueOf(value));
    }

    BEncodeListBuilder add(BEncodeDictionaryBuilder builder);

    BEncodeListBuilder add(BEncodeListBuilder builder);

    BEncodeList build();
}
