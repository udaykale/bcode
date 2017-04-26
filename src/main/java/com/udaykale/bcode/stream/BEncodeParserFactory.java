package com.udaykale.bcode.stream;

import com.udaykale.bcode.core.BEncodeDictionary;
import com.udaykale.bcode.core.BEncodeInteger;
import com.udaykale.bcode.core.BEncodeList;
import com.udaykale.bcode.core.BEncodeString;

import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Map;

import static com.udaykale.bcode.common.BEncodeCommonConstants.DEFAULT_CHARSET;

/**
 * @author uday
 */
public interface BEncodeParserFactory {

    BEncodeParser createParser(Reader reader);

    default BEncodeParser createParser(InputStream in) {
        return createParser(in, DEFAULT_CHARSET);
    }

    BEncodeParser createParser(InputStream in, Charset charset);

    BEncodeParser createParser(BEncodeInteger value);

    BEncodeParser createParser(BEncodeString value);

    BEncodeParser createParser(BEncodeList value);

    BEncodeParser createParser(BEncodeDictionary value);

    Map<String, ?> getConfigInUse();
}
