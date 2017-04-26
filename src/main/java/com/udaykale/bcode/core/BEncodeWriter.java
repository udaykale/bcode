package com.udaykale.bcode.core;

import java.io.Closeable;

/**
 * @author uday
 */
public interface BEncodeWriter extends Closeable {

    default void write(BEncodeValue value) {
        BEncodeValueType valueType = value.getBEncodeValueType();
        switch (valueType) {
            case INTEGER:
                writeInteger((BEncodeInteger) value);
                break;
            case STRING:
                writeString((BEncodeString) value);
                break;
            case LIST:
                writeList((BEncodeList) value);
                break;
            case DICTIONARY:
                writeDictionary((BEncodeDictionary) value);
                break;
            default:
                throw new IllegalArgumentException("Invalid BEncodeValue type: " + valueType);
        }
    }

    void writeInteger(BEncodeInteger value);

    void writeString(BEncodeString value);

    void writeList(BEncodeList value);

    void writeDictionary(BEncodeDictionary value);

    @Override
    void close();
}
