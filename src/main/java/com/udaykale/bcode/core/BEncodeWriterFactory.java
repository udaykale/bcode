package com.udaykale.bcode.core;

import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.udaykale.bcode.common.BEncodeCommonConstants.DEFAULT_CHARSET;

/**
 * @author uday
 */
public interface BEncodeWriterFactory {

    BEncodeWriter createWriter(Writer writer);

    default BEncodeWriter createWriter(OutputStream out) {
        return createWriter(out, DEFAULT_CHARSET);
    }

    BEncodeWriter createWriter(OutputStream out, Charset charset);

    Map<String, ?> getConfigInUse();
}
