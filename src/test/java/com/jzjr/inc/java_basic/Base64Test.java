package com.jzjr.inc.java_basic;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootTest
public class Base64Test {
    /**
     * 编码
     */
    @Test
    public void base64Encoding() {
        String s = Base64.getEncoder().encodeToString("@23中文%￥￥￥".getBytes(StandardCharsets.UTF_8));
        // QDIzJuKApuKApiXvv6Xvv6Xvv6U=
        System.out.println(s);
    }
    /**
     * 解码
     */
    @Test
    public void base63Decodoing() {
        String s = "QDIzJuKApuKApiXvv6Xvv6Xvv6U=";
        byte[] bytes = Base64.getDecoder().decode(s);
        String s1 = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s1);
    }
}
