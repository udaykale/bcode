package com.udaykale.bcode.bdecode;

import com.udaykale.custom.NegativeTest;
import com.udaykale.custom.PositiveTest;
import com.udaykale.custom.TODO;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author uday
 */
public class BdecodeIntegerParserTest {

    @Test
    @PositiveTest
    public void parserIntegerValue12345()
            throws IOException, BdecodeParserException {

        long testInteger = 12345;
        String bencodedTestString = "i12345e";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        long result = bdecodeParser.parseInteger(stringStream);

        Assert.assertTrue(testInteger == result);
    }

    @Test
    @TODO
    @PositiveTest
    public void parser32BitInteger()
            throws IOException, BdecodeParserException {

        long testInteger = 123456789;
        String bencodedTestString = "i123456789e";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        long result = bdecodeParser.parseInteger(stringStream);

        Assert.assertTrue(testInteger == result);
    }

    @Test
    @TODO
    @PositiveTest
    public void parser64BitInteger()
            throws IOException, BdecodeParserException {

        long testInteger = 12345;
        String bencodedTestString = "i12345e";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        long result = bdecodeParser.parseInteger(stringStream);

        Assert.assertTrue(testInteger == result);
    }

    @Test
    @TODO
    @NegativeTest
    public void parserIntegerValueWithouti()
            throws IOException, BdecodeParserException {

        long testInteger = 12345;
        String bencodedTestString = "i12345";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        long result = bdecodeParser.parseInteger(stringStream);

        Assert.assertTrue(testInteger == result);
    }

    @Test
    @TODO
    @NegativeTest
    public void parserIntegerValueWithoute()
            throws IOException, BdecodeParserException {

        long testInteger = 12345;
        String bencodedTestString = "i12345";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        long result = bdecodeParser.parseInteger(stringStream);

        Assert.assertTrue(testInteger == result);
    }

    @Test
    @TODO
    @NegativeTest
    public void parserIntegerValueWithoutie()
            throws IOException, BdecodeParserException {

        long testInteger = 12345;
        String bencodedTestString = "12345";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        long result = bdecodeParser.parseInteger(stringStream);

        Assert.assertTrue(testInteger == result);
    }
}
