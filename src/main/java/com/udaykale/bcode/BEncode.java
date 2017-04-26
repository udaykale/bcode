package com.udaykale.bcode;

import com.udaykale.bcode.core.BEncodeBuilderFactory;
import com.udaykale.bcode.core.BEncodeDictionaryBuilder;
import com.udaykale.bcode.core.BEncodeListBuilder;
import com.udaykale.bcode.core.BEncodeReader;
import com.udaykale.bcode.core.BEncodeReaderFactory;
import com.udaykale.bcode.core.BEncodeWriter;
import com.udaykale.bcode.core.BEncodeWriterFactory;
import com.udaykale.bcode.spi.BEncodeProvider;
import com.udaykale.bcode.stream.BEncodeGenerator;
import com.udaykale.bcode.stream.BEncodeGeneratorFactory;
import com.udaykale.bcode.stream.BEncodeParser;
import com.udaykale.bcode.stream.BEncodeParserFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

/**
 * @author uday
 */
public class BEncode {

    private BEncode() {
    }

    public static BEncodeParser createParser(Reader reader) {
        return BEncodeProvider.provider().createParser(reader);
    }

    public static BEncodeParser createParser(InputStream in) {
        return BEncodeProvider.provider().createParser(in);
    }

    public static BEncodeGenerator createGenerator(Writer writer) {
        return BEncodeProvider.provider().createGenerator(writer);
    }

    public static BEncodeGenerator createGenerator(OutputStream out) {
        return BEncodeProvider.provider().createGenerator(out);
    }

    public static BEncodeParserFactory createParserFactory(Map<String, ?> config) {
        return BEncodeProvider.provider().createParserFactory(config);
    }

    public static BEncodeGeneratorFactory createGeneratorFactory(Map<String, ?> config) {
        return BEncodeProvider.provider().createGeneratorFactory(config);
    }

    public static BEncodeWriter createWriter(Writer writer) {
        return BEncodeProvider.provider().createWriter(writer);
    }

    public static BEncodeWriter createWriter(OutputStream out) {
        return BEncodeProvider.provider().createWriter(out);
    }

    public static BEncodeReader createReader(Reader reader) {
        return BEncodeProvider.provider().createReader(reader);
    }

    public static BEncodeReader createReader(InputStream in) {
        return BEncodeProvider.provider().createReader(in);
    }

    public static BEncodeReaderFactory createReaderFactory(Map<String, ?> config) {
        return BEncodeProvider.provider().createReaderFactory(config);
    }

    public static BEncodeWriterFactory createWriterFactory(Map<String, ?> config) {
        return BEncodeProvider.provider().createWriterFactory(config);
    }

    public static BEncodeListBuilder createListBuilder() {
        return BEncodeProvider.provider().createListBuilder();
    }

    public static BEncodeDictionaryBuilder createDictionaryBuilder() {
        return BEncodeProvider.provider().createDictionaryBuilder();
    }

    public static BEncodeBuilderFactory createBuilderFactory(Map<String, ?> config) {
        return BEncodeProvider.provider().createBuilderFactory(config);
    }
}
