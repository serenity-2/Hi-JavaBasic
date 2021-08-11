package com.jzjr.inc.java_basic;

import com.jzjr.inc.java_basic.annotation.InspireAnnotation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.Arrays;

@SpringBootTest
public class SelfDefinitionAnnotationTest {
    @Test
    @InspireAnnotation(name = "INSPIRE",arr = {24,25,26})
    public void annotationTest() {
        System.out.println("测试自定义注解");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> selfDefinitionAnnotationTest = Class.forName("com.jzjr.inc.java_basic.SelfDefinitionAnnotationTest");
        Method annotationTest = selfDefinitionAnnotationTest.getMethod("annotationTest");
        if (annotationTest.isAnnotationPresent(InspireAnnotation.class)) {
            System.out.println("annotationTest方法上面有InspireAnnotation注解");
            InspireAnnotation annotation = annotationTest.getAnnotation(InspireAnnotation.class);
            System.out.println("name:\t"+annotation.name());
            System.out.println("age:\t"+annotation.age());
            System.out.println("arr:\t"+ Arrays.toString(annotation.arr()));
        } else {
            System.out.println("annotationTest方法上面没有InspireAnnotation注解");
        }
    }
}
