package com.jzjr.inc.java_basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        Collator cmp = Collator.getInstance(java.util.Locale.CHINA);
        String[] arr = {"金","武","重来","长","长","成"};
        List<String> list = Arrays.asList(arr);
        Arrays.sort(arr, cmp);
        System.out.println(list);
    }

    @Test
    public void test03() {
        System.out.println(String.join("-", "A", "B", "C"));
    }
}
