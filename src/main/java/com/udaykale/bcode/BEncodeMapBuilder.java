package com.udaykale.bcode;

import java.math.BigInteger;
import java.nio.charset.Charset;

/**
 * @author uday
 */
public interface BEncodeMapBuilder {

    BEncodeMapBuilder add(BEncodeString name, BEncodeInteger value);

    BEncodeMapBuilder add(BEncodeString name, BEncodeString value);

    BEncodeMapBuilder add(BEncodeString name, BEncodeList value);

    BEncodeMapBuilder add(BEncodeString name, BEncodeMap value);

    BEncodeMapBuilder add(BEncodeString name, byte[] value);

    BEncodeMapBuilder add(BEncodeString name, int value);

    BEncodeMapBuilder add(BEncodeString name, long value);

    BEncodeMapBuilder add(BEncodeString name, BigInteger value);

    BEncodeMapBuilder add(BEncodeString name, BEncodeMapBuilder builder);

    BEncodeMapBuilder add(BEncodeString name, BEncodeListBuilder builder);

    default BEncodeMap build() {
        return build(Charset.defaultCharset());
    }

    BEncodeMap build(Charset charset);
}
