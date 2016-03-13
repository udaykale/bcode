package com.udaykale.custom;

import java.lang.annotation.*;

/**
 * @author uday
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface NegativeTest {
}
