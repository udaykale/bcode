package com.udaykale.bcode.core;

import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.udaykale.bcode.common.BEncodeCommonConstants.DEFAULT_CHARSET;

/**
 * @author uday
 */
public interface BEncodeReaderFactory {

    BEncodeReader createReader(Reader reader);

    default BEncodeReader createReader(InputStream in) {
        return createReader(in, DEFAULT_CHARSET);
    }

    BEncodeReader createReader(InputStream in, Charset charset);

    Map<String, ?> getConfigInUse();
}
