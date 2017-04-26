package com.udaykale.bcode.spi;

import com.udaykale.bcode.core.BEncodeException;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author uday
 */
class BEncodeProviderUtil {
    private static final String DEFAULT_BENCODE_PROVIDER = "com.udaykale.bcodeimpl.spi.BEncodeProviderImpl";

    static BEncodeProvider provider() {
        ServiceLoader<BEncodeProvider> loader = ServiceLoader.load(BEncodeProvider.class);
        Iterator<BEncodeProvider> it = loader.iterator();
        if (it.hasNext()) {
            return it.next();
        }

        try {
            Class<?> clazz = Class.forName(DEFAULT_BENCODE_PROVIDER);
            return (BEncodeProvider) clazz.newInstance();
        } catch (ClassNotFoundException x) {
            throw new BEncodeException("Provider " + DEFAULT_BENCODE_PROVIDER + " not found", x);
        } catch (Exception x) {
            throw new BEncodeException("Provider " + DEFAULT_BENCODE_PROVIDER + " could not be instantiated: " + x, x);
        }
    }

}
