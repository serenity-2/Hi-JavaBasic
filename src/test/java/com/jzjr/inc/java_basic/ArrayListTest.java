package com.jzjr.inc.java_basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Objects;

@SpringBootTest
public class ArrayListTest {
    @Test
    public void test01() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.remove("2");
        String S = null;
        try {
            System.out.println(S.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(arrayList);
    }

    @Test
    public void test02() {
       send(null);
    }

    public void send(String type) {
        testA(type);
    }

    private void testA(String type) {
        testB(type);
    }

    private void testB(String type) {
        System.out.println(type.split(","));
    }
}
