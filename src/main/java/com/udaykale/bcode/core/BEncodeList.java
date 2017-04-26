package com.udaykale.bcode.core;

import java.math.BigInteger;
import java.util.List;

/**
 * @author uday
 */
public interface BEncodeList extends BEncodeValue, List<BEncodeValue> {

    default BEncodeInteger getBEncodeInteger(int i) {
        return (BEncodeInteger) BEncodeUtil.getBEncodeValue(get(i), BEncodeValueType.INTEGER);
    }

    default BEncodeString getBEncodeString(int i) {
        return (BEncodeString) BEncodeUtil.getBEncodeValue(get(i), BEncodeValueType.STRING);
    }

    default BEncodeList getBEncodeList(int i) {
        return (BEncodeList) BEncodeUtil.getBEncodeValue(get(i), BEncodeValueType.LIST);
    }

    default BEncodeDictionary getBEncodeDictionary(int i) {
        return (BEncodeDictionary) BEncodeUtil.getBEncodeValue(get(i), BEncodeValueType.DICTIONARY);
    }

    default int integerValue(int i) {
        return getBEncodeInteger(i).integerValue();
    }

    default long longValue(int i) {
        return getBEncodeInteger(i).longValue();
    }

    default BigInteger bigIntegerValue(int i) {
        return getBEncodeInteger(i).bigIntegerValue();
    }
}
