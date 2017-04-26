package com.udaykale.bcode.stream;

import java.util.Objects;

/**
 * @author uday
 */
class BEncodeGeneratorUtil {

    static void validateCurrentContext(BEncodeContextType currentContext, BEncodeContextType expectedContext) {
        if (currentContext != expectedContext) {
            throw new BEncodeGeneratorException("Cannot use this method in context: " + currentContext);
        }
    }
}
