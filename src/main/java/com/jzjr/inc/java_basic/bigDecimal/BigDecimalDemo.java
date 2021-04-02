package com.jzjr.inc.java_basic.bigDecimal;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(1);
        BigDecimal b = new BigDecimal(3);
        BigDecimal c = a.divide(b,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(c);

    }
}
