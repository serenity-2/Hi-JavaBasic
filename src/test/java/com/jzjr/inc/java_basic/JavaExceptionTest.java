package com.jzjr.inc.java_basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

@SpringBootTest
public class JavaExceptionTest {
    @Test
    public void readPreferance() throws FileNotFoundException {
        try {
            // do something
            System.exit(1);
        } finally{
            System.out.println("print finaly");
        }
        String fileName = null;
        Objects.requireNonNull(fileName);
        FileInputStream fileInputStream = new FileInputStream(fileName);
    }
}
