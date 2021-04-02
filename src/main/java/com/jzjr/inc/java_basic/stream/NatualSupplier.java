package com.jzjr.inc.java_basic.stream;

import java.util.function.Supplier;

class NatualSupplier implements Supplier<Long> {
    long n = 0;

    public Long get() {
        n++;
        return n;
    }
}