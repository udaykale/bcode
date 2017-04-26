package com.udaykale.bcode.core;

import java.util.Map;

/**
 * @author uday
 */
public interface BEncodeBuilderFactory {

    BEncodeListBuilder createBEncodeListBuilder();

    BEncodeDictionaryBuilder createBEncodeDictionaryBuilder();

    Map<String, ?> getConfigInUse();
}
