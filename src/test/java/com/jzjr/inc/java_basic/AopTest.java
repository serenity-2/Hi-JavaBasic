package com.jzjr.inc.java_basic;

import com.jzjr.inc.java_basic.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@SpringBootTest
public class AopTest {

    @Test
    public void simpleAop() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add(0);
        arrayList.add('c');
        arrayList.add(true);
        System.out.println(arrayList);
    }

    @Test
    public void changeIntArr() {
        Integer[] arrInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        change(arrInt, 0, 8);
        System.out.println("arr = " + Arrays.asList(arrInt));
    }

    @Test
    public void changeStringArr() {
        String[] arrString = {"A", "C", "C"};
        change(arrString, 0, 2);
        System.out.println("arr = " + Arrays.asList(arrString));
    }

    private static <T> void change(T[] arr, int firstIndex, int secondIndex) {
        T tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }

    @Test
    public void sortTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Object> StringList = new ArrayList<>();
        list = StringList;
    }

    @Test
    public void saveUser() {
        User lily = new User("lily",24);
        User moko = new User("moko",25);
        Map<Object, Object> hashMap = new HashMap<>();
        hashMap.put(lily,"lily");
        Object o = hashMap.get(moko);
        System.out.println(o);
    }

    @Test
    public void testChange() {
        System.out.println("dev-20200915");
    }

}


