package com.udaykale.bcode;

import java.nio.charset.Charset;

/**
 * @author uday
 */
public interface BEncodeString extends BEncodeValue {

    Charset getCharset();

    byte[] getByteSequence();
}
