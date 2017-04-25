package com.udaykale.bcode;

/**
 * @author uday
 */
public interface BEncodeValue {

    BEncodeValueType getBEncodeValueType();

    @Override
    String toString();

    @Override
    boolean equals(Object object);

    @Override
    int hashCode();
}
