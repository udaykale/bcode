package com.udaykale.bcode.bdecode;

import com.udaykale.custom.NegativeTest;
import com.udaykale.custom.PositiveTest;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author uday
 */
public class BdecodeStringParserTest {

    @Test
    @PositiveTest
    public void parseStringOfLength10Test()
            throws IOException, BdecodeParserException {

        String testString = "cardinally";
        String bencodedTestString = "10:cardinally";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        String result = bdecodeParser.parseString(stringStream);

        Assert.assertTrue(testString.equals(result));
    }

    @Test(expected = BdecodeParserException.class)
    @NegativeTest
    public void parseStringWithLengthGreaterThanStreamTest()
            throws IOException, BdecodeParserException {

        String bencodedTestString = "120:cardinally";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        bdecodeParser.parseString(stringStream);
    }

    @Test
    @NegativeTest
    public void parseStringWithLengthLessrThanStreamTest()
            throws IOException, BdecodeParserException {

        String testString = "cardin";
        String bencodedTestString = "6:cardinally";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        String result = bdecodeParser.parseString(stringStream);

        Assert.assertTrue(testString.equals(result));
    }

    @Test(expected = BdecodeParserException.class)
    @NegativeTest
    public void parseStringOfLength0Test()
            throws IOException, BdecodeParserException {

        String bencodedTestString = "0:cardinally";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        bdecodeParser.parseString(stringStream);
    }

    @Test(expected = BdecodeParserException.class)
    @NegativeTest
    public void parseStringOfLengthNoTest()
            throws IOException, BdecodeParserException {

        String bencodedTestString = ":cardinally";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        bdecodeParser.parseString(stringStream);
    }

    @Test(expected = BdecodeParserException.class)
    @NegativeTest
    public void parseStringWithNoColonTest()
            throws IOException, BdecodeParserException {

        String bencodedTestString = "cardinally";

        InputStream stringStream = new ByteArrayInputStream(bencodedTestString.getBytes());

        BdecodeParser bdecodeParser = new BdecodeParser();

        bdecodeParser.parseString(stringStream);
    }
}