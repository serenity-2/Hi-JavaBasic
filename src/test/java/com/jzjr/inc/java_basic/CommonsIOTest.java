package com.jzjr.inc.java_basic;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootTest
public class CommonsIOTest {
    /**
     * 拷贝文件  将a.txt的内容拷贝到b.txt
     *
     * @throws IOException
     */
    @Test
    public void copyFile() throws IOException {
        File a = new File("C:\\Users\\qianchangqing.ext\\Desktop\\a.txt");
        //自动创建并拷贝文件
        File b = new File("C:\\Users\\qianchangqing.ext\\Desktop\\b.txt");
        FileUtils.copyFile(a, b);
    }

    /**
     * 删除文件
     */
    @Test
    public void deleteFile() throws IOException {
        File b = new File("C:\\Users\\qianchangqing.ext\\Desktop\\bb.txt");
        FileUtils.forceDelete(b);
    }

    /**
     * 比较文件内容是否相同
     */
    @Test
    public void compareFile() throws IOException {
        File a = new File("C:\\Users\\qianchangqing.ext\\Desktop\\a.txt");
        File b = new File("C:\\Users\\qianchangqing.ext\\Desktop\\b.txt");
        boolean result = FileUtils.contentEquals(a, b);
        System.out.println(result);
    }

    /**
     * 移动文件
     *
     * @throws IOException
     */
    @Test
    public void moveFile() throws IOException {
        File a = new File("C:\\Users\\qianchangqing.ext\\Desktop\\a.txt");
        File b = new File("C:\\Users\\qianchangqing.ext\\Desktop\\ALL_FILES");
        FileUtils.moveToDirectory(a, b, true);
    }

    /**
     * 读取文件内容
     */
    @Test
    public void readFile() throws IOException {
        File a = new File("C:\\Users\\qianchangqing.ext\\Desktop\\a.txt");
        String content = FileUtils.readFileToString(a, StandardCharsets.UTF_8);
        System.out.println(content);
        List<String> contents = FileUtils.readLines(a, StandardCharsets.UTF_8);
        contents.forEach(System.out::println);
    }

    /**
     * 写入文件内容
     */
    @Test
    public void writeFile() throws IOException {
        File a = new File("C:\\Users\\qianchangqing.ext\\Desktop\\a.txt");
        FileUtils.writeStringToFile(a,"have a good time",StandardCharsets.UTF_8);
    }


}
