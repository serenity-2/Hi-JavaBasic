package com.jzjr.inc.java_basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@SpringBootTest
public class IOTest {
    @Test
    public void readConsole() throws IOException {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }

    /**
     * 测试文件输入流
     *
     * @throws IOException
     */
    @Test
    public void demo01() {
        File file = new File("C:\\Users\\qianchangqing.ext\\Desktop\\banana.txt");
        System.out.println("文件名称：\t" + file.getName());
        System.out.println("文件路径：\t" + file);
        //此处使用try-with-resource自动关闭流
        try (FileInputStream fis = new FileInputStream(file)) {
            int i;
            byte[] bytes = new byte[1024];
            StringBuilder builder = new StringBuilder();
            //从输入流中读取bute大小的字节，并将读取的字节存放到bute数组中，并返回读取的字节数
            while ((i = fis.read(bytes)) != -1) {
                //通过byte数组，数组的起始索引，数组的长度来构建String
                builder.append(new String(bytes, 0, i));
            }
            System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试文件输出流
     */
    @Test
    public void demo02() {
        //append:true 在原文本后面追加，false：覆盖原文本，默认为flase
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\qianchangqing.ext\\Desktop\\banana.txt", true)) {
            String content = "i like eat pear";
            fos.write(content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo03() {
        File file = new File("C:\\Users");
        if (file.isDirectory()) {
            System.out.println("文件夹：\t" + file.getName());
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                File file1 = new File("C:\\Users\\" + list[i]);
                if (file1.isDirectory()) {
                    System.out.println(file1 + "是一个文件夹");
                } else {
                    System.out.println(file1 + "是一个文件");
                }
            }
        }
    }

    /**
     * 将控制台用户输入的字母转大写
     */
    @Test
    public void byteStreamTest() {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(12)) {
            //读取用户控制台输入数据
            Scanner sc = new Scanner(System.in);
            String next = sc.next();
            baos.write(next.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = baos.toByteArray();
            System.out.println("print the content");
            for (int i = 0; i < bytes.length; i++) {
                //打印字符
                System.out.print((char) bytes[i]);
            }
            System.out.println();
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            int c;
            System.out.println("convert character to upper case");
            for (int i = 0; i < 1; i++) {
                while ((c = bais.read()) != -1) {
                    System.out.print(Character.toUpperCase((char) c));
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
