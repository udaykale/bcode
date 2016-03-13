package com.udaykale.bcode.bdecode;

import com.udaykale.bcode.common.BcodeConstant;
import com.udaykale.bcode.common.CharsetDependentCache;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

/**
 * This class is responsible for parsing Bdecoded stream
 *
 * @author uday
 */
public final class BdecodeParser {

    private CharsetDependentCache charsetDependentCache;

    public BdecodeParser() {
        this.charsetDependentCache = new CharsetDependentCache(Charset.defaultCharset());
    }

    public BdecodeParser(Charset charset) {
        this.charsetDependentCache = new CharsetDependentCache(charset);
    }

    public BdecodeParser(CharsetDependentCache charsetDependentCache) {
        this.charsetDependentCache = charsetDependentCache;
    }

    /**
     * Deserialize a bencoded string from the input stream
     *
     * @param inputStream Stream containing bencoded bytes
     * @return String obtained from the inputStream
     * @throws IOException
     */
    public String parseString(InputStream inputStream)
            throws IOException, BdecodeParserException {

        StringBuilder stringBuilder = new StringBuilder(BcodeConstant.NUM_DIGITS);

        // Extract string length
        int byt = inputStream.read();
        while (byt != BcodeConstant.EOS) {
            if (byt == charsetDependentCache.COLON) {
                break;
            }
            stringBuilder.append((char) byt);
            byt = inputStream.read();
        }

        int size = 0;
        String lengthString = stringBuilder.toString();

        // Validate string length
        try {
            size = Integer.parseInt(lengthString);
        } catch (NumberFormatException e) {
            throw new BdecodeParserException(String.format("Invalid String: Expected an integer, got %s.", lengthString));
        }

        if (size == 0) {
            throw new BdecodeParserException("Invalid String: String size cannot be 0.");
        }

        int i = 0;
        byt = inputStream.read();
        stringBuilder = new StringBuilder(size);
        // Extract string
        while (byt != BcodeConstant.EOS && i < size) {
            i++;
            stringBuilder.append((char) byt);
            byt = inputStream.read();
        }

        // Validate string size and stream size
        if (i != size) {
            throw new BdecodeParserException("Invalid String: Given size is larger than the stream size.");
        }

        return stringBuilder.toString();
    }

    /**
     * Deserialize a bencoded integer from the input stream
     *
     * @param inputStream Stream containing bencoded bytes
     * @return Integer obtained from the inputStream
     * @throws IOException
     * @throws BdecodeParserException
     */
    public long parseInteger(InputStream inputStream)
            throws IOException, BdecodeParserException {

        StringBuilder stringBuilder = new StringBuilder(BcodeConstant.NUM_DIGITS);

        int byt = inputStream.read();
        if (byt != charsetDependentCache.INTEGER) {
            throw new BdecodeParserException("Invalid Integer: Stream does not start with the character 'i'");
        }

        byt = inputStream.read();
        while (byt != BcodeConstant.EOS && byt != charsetDependentCache.END) {
            stringBuilder.append((char) byt);
            byt = inputStream.read();
        }

        return Long.parseLong(stringBuilder.toString());
    }

    public List<Object> parseList() {

        return null;
    }

    public TreeMap<String, Object> parseDictionary() {

        return null;
    }
}