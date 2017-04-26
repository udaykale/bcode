package com.udaykale.bcode.core;

import java.io.Closeable;

/**
 * @author uday
 */
public interface BEncodeReader extends Closeable {

    BEncodeValue read();

    BEncodeInteger readInteger();

    BEncodeString readString();

    BEncodeDictionary readDictionary();

    BEncodeList readList();

    @Override
    void close();
}
