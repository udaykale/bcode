package com.udaykale.bcode.spi;

import com.udaykale.bcode.core.BEncodeBuilderFactory;
import com.udaykale.bcode.core.BEncodeDictionaryBuilder;
import com.udaykale.bcode.core.BEncodeListBuilder;
import com.udaykale.bcode.core.BEncodeReader;
import com.udaykale.bcode.core.BEncodeReaderFactory;
import com.udaykale.bcode.core.BEncodeWriter;
import com.udaykale.bcode.core.BEncodeWriterFactory;
import com.udaykale.bcode.stream.BEncodeGenerator;
import com.udaykale.bcode.stream.BEncodeGeneratorFactory;
import com.udaykale.bcode.stream.BEncodeParser;
import com.udaykale.bcode.stream.BEncodeParserFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author uday
 */
public interface BEncodeProvider {

    static BEncodeProvider provider() {
        return BEncodeProviderUtil.provider();
    }

    Map<String, ?> defaultConfiguration();

    BEncodeParserFactory createParserFactory(Map<String, ?> config);

    default BEncodeParser createParser(Reader reader) {
        return createParserFactory(defaultConfiguration()).createParser(reader);
    }

    default BEncodeParser createParser(InputStream in) {
        return createParserFactory(defaultConfiguration()).createParser(in);
    }

    default BEncodeParser createParser(InputStream in, Charset charset) {
        return createParserFactory(defaultConfiguration()).createParser(in, charset);
    }

    BEncodeGeneratorFactory createGeneratorFactory(Map<String, ?> config);

    default BEncodeGenerator createGenerator(Writer writer) {
        return createGeneratorFactory(defaultConfiguration()).createGenerator(writer);
    }

    default BEncodeGenerator createGenerator(OutputStream out) {
        return createGeneratorFactory(defaultConfiguration()).createGenerator(out);
    }

    default BEncodeGenerator createGenerator(OutputStream out, Charset charset) {
        return createGeneratorFactory(defaultConfiguration()).createGenerator(out, charset);
    }

    BEncodeReaderFactory createReaderFactory(Map<String, ?> config);

    default BEncodeReader createReader(Reader reader) {
        return createReaderFactory(defaultConfiguration()).createReader(reader);
    }

    default BEncodeReader createReader(InputStream in) {
        return createReaderFactory(defaultConfiguration()).createReader(in);
    }

    default BEncodeReader createReader(InputStream in, Charset charset) {
        return createReaderFactory(defaultConfiguration()).createReader(in, charset);
    }

    BEncodeWriterFactory createWriterFactory(Map<String, ?> config);

    default BEncodeWriter createWriter(Writer writer) {
        return createWriterFactory(defaultConfiguration()).createWriter(writer);
    }

    default BEncodeWriter createWriter(OutputStream out) {
        return createWriterFactory(defaultConfiguration()).createWriter(out);
    }

    default BEncodeWriter createWriter(OutputStream out, Charset charset) {
        return createWriterFactory(defaultConfiguration()).createWriter(out, charset);
    }

    BEncodeBuilderFactory createBuilderFactory(Map<String, ?> config);

    default BEncodeDictionaryBuilder createDictionaryBuilder() {
        return createBuilderFactory(defaultConfiguration()).createBEncodeDictionaryBuilder();
    }

    default BEncodeListBuilder createListBuilder() {
        return createBuilderFactory(defaultConfiguration()).createBEncodeListBuilder();
    }
}
