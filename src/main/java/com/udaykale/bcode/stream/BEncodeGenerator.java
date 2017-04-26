package com.udaykale.bcode.stream;

import com.udaykale.bcode.core.BEncodeInteger;
import com.udaykale.bcode.core.BEncodeString;
import com.udaykale.bcode.core.BEncodeValue;
import com.udaykale.bcode.core.BEncodeValueType;

import java.io.Closeable;
import java.io.Flushable;
import java.math.BigInteger;

/**
 * @author uday
 */
public interface BEncodeGenerator extends Flushable, Closeable {

    BEncodeContextType currentContext();

    BEncodeGenerator writeStartDictionary();

    BEncodeGenerator writeStartDictionary(BEncodeString name);

    BEncodeGenerator writeStartList();

    BEncodeGenerator writeStartList(BEncodeString name);

    default BEncodeGenerator write(BEncodeString name, BEncodeValue value) {
        BEncodeGeneratorUtil.validateCurrentContext(currentContext(), BEncodeContextType.START_DICTIONARY);
        BEncodeValueType valueType = value.getBEncodeValueType();
        switch (valueType) {
            case INTEGER:
                return write(name, ((BEncodeInteger) value));
            case STRING:
                return write(name, (BEncodeString) value);
            default:
                throw new IllegalArgumentException("Invalid Value Type: " + valueType);
        }
    }

    BEncodeGenerator write(BEncodeString name, byte[] value);

    default BEncodeGenerator write(BEncodeString name, BEncodeString value) {
        BEncodeGeneratorUtil.validateCurrentContext(currentContext(), BEncodeContextType.START_DICTIONARY);
        return write(name, value.getByteSequence());
    }

    BEncodeGenerator write(BEncodeString name, BigInteger value);

    default BEncodeGenerator write(BEncodeString name, BEncodeInteger value) {
        BEncodeGeneratorUtil.validateCurrentContext(currentContext(), BEncodeContextType.START_DICTIONARY);
        return write(name, value.bigIntegerValue());
    }

    default BEncodeGenerator write(BEncodeString name, int value) {
        BEncodeGeneratorUtil.validateCurrentContext(currentContext(), BEncodeContextType.START_DICTIONARY);
        return write(name, BigInteger.valueOf(value));
    }

    default BEncodeGenerator write(BEncodeString name, long value) {
        BEncodeGeneratorUtil.validateCurrentContext(currentContext(), BEncodeContextType.START_DICTIONARY);
        return write(name, BigInteger.valueOf(value));
    }

    default BEncodeGenerator write(BEncodeValue value) {
        BEncodeGeneratorUtil.validateCurrentContext(currentContext(), BEncodeContextType.START_LIST);
        BEncodeValueType valueType = value.getBEncodeValueType();
        switch (valueType) {
            case INTEGER:
                return write(((BEncodeInteger) value));
            case STRING:
                return write((BEncodeString) value);
            default:
                throw new IllegalArgumentException("Invalid Value Type: " + valueType);
        }
    }

    BEncodeGenerator write(byte[] value);

    default BEncodeGenerator write(BEncodeString value) {
        BEncodeGeneratorUtil.validateCurrentContext(currentContext(), BEncodeContextType.START_LIST);
        return write(value.getByteSequence());
    }

    BEncodeGenerator write(BigInteger value);

    default BEncodeGenerator write(BEncodeInteger value) {
        BEncodeGeneratorUtil.validateCurrentContext(currentContext(), BEncodeContextType.START_LIST);
        return write(value.bigIntegerValue());
    }

    default BEncodeGenerator write(int value) {
        BEncodeGeneratorUtil.validateCurrentContext(currentContext(), BEncodeContextType.START_LIST);
        return write(BigInteger.valueOf(value));
    }

    default BEncodeGenerator write(long value) {
        BEncodeGeneratorUtil.validateCurrentContext(currentContext(), BEncodeContextType.START_LIST);
        return write(BigInteger.valueOf(value));
    }

    BEncodeGenerator writeEnd();

    @Override
    void close();

    @Override
    void flush();
}
