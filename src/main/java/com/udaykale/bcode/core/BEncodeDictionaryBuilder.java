package com.udaykale.bcode.core;

import java.math.BigInteger;

/**
 * @author uday
 */
public interface BEncodeDictionaryBuilder {

    BEncodeDictionaryBuilder add(BEncodeString name, BEncodeValue value);

    default BEncodeDictionaryBuilder add(BEncodeString name, BEncodeInteger value) {
        return add(name, value.bigIntegerValue());
    }

    default BEncodeDictionaryBuilder add(BEncodeString name, BEncodeString value) {
        return add(name, value.getByteSequence());
    }

    BEncodeDictionaryBuilder add(BEncodeString name, BEncodeList value);

    BEncodeDictionaryBuilder add(BEncodeString name, BEncodeDictionary value);

    BEncodeDictionaryBuilder add(BEncodeString name, byte[] value);

    default BEncodeDictionaryBuilder add(BEncodeString name, int value) {
        return add(name, BigInteger.valueOf(value));
    }

    default BEncodeDictionaryBuilder add(BEncodeString name, long value) {
        return add(name, BigInteger.valueOf(value));
    }

    BEncodeDictionaryBuilder add(BEncodeString name, BigInteger value);

    BEncodeDictionaryBuilder add(BEncodeString name, BEncodeDictionaryBuilder builder);

    BEncodeDictionaryBuilder add(BEncodeString name, BEncodeListBuilder builder);

    BEncodeDictionary build();
}
