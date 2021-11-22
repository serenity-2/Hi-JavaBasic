package com.jzjr.inc.java_basic;

import com.jzjr.inc.java_basic.bean.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class JavaUtilsTest {

    @Test
    @DisplayName("list集合拼接成以逗号分割的字符串")
    public void  test01() {
        List<String> list = Arrays.asList("a,b,c");
        //第一种方法，使用Stream
        String join = list.stream().collect(Collectors.joining(","));
        //a,b,c
        //使用String自带的join方法
        String join1 = String.join(",", list);
        //a,b,c
    }

    @Test
    @DisplayName("比较两个对象是否相等")
    public void test02() {
        User moko = new User("moko", 24);
        User daisy = new User("daisy", 25);
        boolean equals = Objects.equals(moko, daisy);
        //flase
    }

    @Test
    @DisplayName("两个List集合取交集")
    public void test03() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        list1.add(5);
        //retainAll() 方法用于保留 arraylist 中在指定集合中也存在的那些元素，也就是删除指定集合中不存在的那些元素。
        //如果 arraylist 中删除了元素则返回 true。
        boolean b = list.retainAll(list1);
        //true
        System.out.println(list);
        //3
    }

    /**
     * apache commons工具类库
     */

    /**
     * commons-lang3
     */
    @Test
    @DisplayName("字符串判空")
    public void test04() {
        String s1 = "";
        String s2 = null;
        String s3 = " ";
        boolean b1 = StringUtils.isEmpty(s1); // true
        boolean b2 = StringUtils.isEmpty(s2); // true
        boolean b3 = StringUtils.isEmpty(s3); // false
        boolean b4 = StringUtils.isBlank(s1); // true
        boolean b5 = StringUtils.isBlank(s2); // true
        boolean b6 = StringUtils.isBlank(s3); // true
    }

    @Test
    @DisplayName("首字母转大写")
    public void test05() {
        String s = "china";
        String capitalize = StringUtils.capitalize(s);
        //China
    }

    @Test
    @DisplayName("重复拼接字符串")
    public void test06() {
        String repeat = StringUtils.repeat("ab", 2);
        //abab
    }

    @Test
    @DisplayName("格式化日期")
    public void test07() throws ParseException {
        //Date类型转String类型
        String today = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(today);
        //java原生
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(now);
        //String转日期
        Date date = DateUtils.parseDate("2021-12-31 00:00:00", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        // 计算一个小时后的日期
        Date future = DateUtils.addHours(new Date(), 1);
    }

    @Test
    @DisplayName("包装临时对象:当一个方法需要返回两个及以上字段时，我们一般会封装成一个临时对象返回，现在有了Pair和Triple就不需要了")
    public void test08 () {
        ImmutablePair<String, String> daisy = ImmutablePair.of("daisy", "24");
        //ta的名字叫daisy,今年24岁
        System.out.println("ta的名字叫"+daisy.getLeft()+",今年"+ daisy.getRight()+"岁");
        ImmutableTriple<String, String, String> triple = ImmutableTriple.of("moko", "宇宙飞船", "火星");
        //ta的名字叫moko,一年前驾驶宇宙飞船来到了火星
        System.out.println("ta的名字叫"+triple.getLeft()+",一年前驾驶"+triple.getMiddle()+"来到了"+triple.getRight());
    }

    /**集合工具类
     * >commons-collections4
     */
    public void test09() {

    }
}
