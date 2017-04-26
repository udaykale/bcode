package com.udaykale.bcode.stream;

import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.udaykale.bcode.common.BEncodeCommonConstants.DEFAULT_CHARSET;

/**
 * @author uday
 */
public interface BEncodeGeneratorFactory {

    BEncodeGenerator createGenerator(Writer writer);

    default BEncodeGenerator createGenerator(OutputStream out) {
        return createGenerator(out, DEFAULT_CHARSET);
    }

    BEncodeGenerator createGenerator(OutputStream out, Charset charset);

    Map<String, ?> getConfigInUse();
}
