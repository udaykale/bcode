package com.udaykale.bcode.core;

import java.nio.charset.Charset;

/**
 * @author uday
 */
public interface BEncodeString extends BEncodeValue {

    Charset getCharset();

    byte[] getByteSequence();
}
