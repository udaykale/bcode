package com.udaykale.bcode;

/**
 * @author uday
 */
class BEncodeUtil {

    private static final String INVALID_VALUE_TYPE_MESSAGE = "Invalid Value type expected: '%s', found: '%s'";

    static BEncodeValue getBEncodeValue(BEncodeValue value, BEncodeValueType expectedValueType) {
        if (value == null) {
            return null;
        }
        BEncodeValueType valueType = value.getBEncodeValueType();
        if (valueType != expectedValueType) {
            throw new BEncodeException(String.format(INVALID_VALUE_TYPE_MESSAGE, expectedValueType, valueType));
        }
        return value;
    }
}
