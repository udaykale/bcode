package com.udaykale.bcode;

import java.math.BigInteger;
import java.nio.charset.Charset;

/**
 * @author uday
 */
public interface BEncodeListBuilder {

    BEncodeListBuilder add(BEncodeValue value);

    BEncodeListBuilder add(BEncodeString value);

    BEncodeListBuilder add(String value);

    BEncodeListBuilder add(BEncodeInteger value);

    BEncodeListBuilder add(BigInteger value);

    BEncodeListBuilder add(byte[] value);

    BEncodeListBuilder add(int value);

    BEncodeListBuilder add(long value);

    BEncodeListBuilder add(BEncodeMapBuilder builder);

    BEncodeListBuilder add(BEncodeListBuilder builder);

    default BEncodeList build() {
        return build(Charset.defaultCharset());
    }

    BEncodeList build(Charset charset);
}
