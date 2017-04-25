package com.udaykale.bcode;

import java.math.BigInteger;
import java.util.Map;

/**
 * @author uday
 */
public interface BEncodeMap extends BEncodeValue, Map<BEncodeString, BEncodeValue> {

    default BEncodeInteger getBEncodeInteger(BEncodeString name) {
        return (BEncodeInteger) BEncodeUtil.getBEncodeValue(get(name), BEncodeValueType.INTEGER);
    }

    default BEncodeString getBEncodeString(BEncodeString name) {
        return (BEncodeString) BEncodeUtil.getBEncodeValue(get(name), BEncodeValueType.STRING);
    }

    default BEncodeList getBEncodeList(BEncodeString name) {
        return (BEncodeList) BEncodeUtil.getBEncodeValue(get(name), BEncodeValueType.LIST);
    }

    default BEncodeMap getBEncodeMap(BEncodeString name) {
        return (BEncodeMap) BEncodeUtil.getBEncodeValue(get(name), BEncodeValueType.DICTIONARY);
    }

    default int integerValue(BEncodeString name) {
        return getBEncodeInteger(name).integerValue();
    }

    default long longValue(BEncodeString name) {
        return getBEncodeInteger(name).longValue();
    }

    default BigInteger bigIntegerValue(BEncodeString name) {
        return getBEncodeInteger(name).bigIntegerValue();
    }
}
