package com.jzjr.inc.java_basic;

import com.jzjr.inc.java_basic.bean.Product;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
public class JavaStream {

    /**
     * distinct保证输出流中的唯一元素
     */
    @Test
    public void distinct() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 5, 4, 3, 2, 1);
        List<Integer> integerList = integerStream.distinct().collect(Collectors.toList());
        //1,2,3,4,5
        integerList.forEach(System.out::println);
    }


    @Test
    public void rangeAndrangeClosed() {
        //1,2,3,4,5,6,7,8,9
        IntStream.range(1, 10).forEach(System.out::println);
        //1,2,3,4,5,6,7,8,9,10
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
    }

    @Test
    public void nonInterface() {
        ArrayList<String> list = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            list.add(i + "");
        }
        ArrayList<String> list2 = Lists.newArrayList();
        // 副作用代码
        list.parallelStream().forEach(s -> list2.add(s));
        System.out.println(list2);
    }

    @Test
    public void filter() {
        List<Integer> integerList = IntStream.of(2, 0, 0, 1, 6, 2, 1, 7, 2, 1, 8)
                .filter(i -> i % 2 == 0)
                .boxed() //将IntStream转换为IntegerStream,否则无法使用collect
                .collect(Collectors.toList());
        integerList.forEach(System.out::println);
    }

    @Test
    public void map() {
        List<Integer> list = Stream.of('a', 'b', 'c').map(e -> e.hashCode())
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    @Test
    public void flatMap() {
        // 将集合中的字符串中单词提取出来，不考虑特殊字符
        List<String> words = Arrays.asList("hello c++", "hello java", "hello python");
        List<String> result = words.stream()
                // 将单词按照空格切合，返回Stream<String[]>类型的数据
                .map(word -> word.split(" "))
                // 将Stream<String[]>转换为Stream<String>
                .flatMap(Arrays::stream)
                // 去重
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void limit() {
        List<Integer> list = IntStream.of(1, 2, 3, 4, 5)
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
        //1,2,3
        list.forEach(System.out::println);
    }

    @Test
    public void peek() {
        List<String> list = Stream.of("one", "two", "three", "four")
                .peek(e -> System.out.println("Peeked value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        list.forEach(System.out::println);

    }

    @Test
    public void sorted() {
        String[] arr = new String[]{"b_123", "c+342", "b#632", "d_123"};
        List<String> l = Arrays.stream(arr)
                .sorted((s1, s2) -> {
                    if (s1.charAt(0) == s2.charAt(0)) {
                        return s1.substring(2).compareTo(s2.substring(2));
                    } else {
                        return s1.charAt(0) - s2.charAt(0);
                    }
                })
                .collect(Collectors.toList());
        //[b_123, b#632, c+342, d_123]
        System.out.println(l);

    }

    @Test
    public void skip() {
        String[] arr = new String[]{"a", "b", "c", "d"};
        Arrays.stream(arr)
                .skip(2)
                //c d
                .forEach(System.out::println);
    }

    @Test
    public void match() {
        boolean result = IntStream.range(1, 20)
                .anyMatch(e -> e == 20);
        //false
        System.out.println(result);
    }

    @Test
    public void count() {
        String[] arr = new String[]{"a", "b", "c", "d"};
        //4
        long count = Arrays.stream(arr).count();
    }

    @Test
    public void groupingby() {
        Product prod1 = new Product(1L, 1, new BigDecimal("15.5"), "面包", "零食");
        Product prod2 = new Product(2L, 2, new BigDecimal("20"), "饼干", "零食");
        Product prod3 = new Product(3L, 3, new BigDecimal("30"), "月饼", "零食");
        Product prod4 = new Product(4L, 3, new BigDecimal("10"), "青岛啤酒", "啤酒");
        Product prod5 = new Product(5L, 10, new BigDecimal("15"), "百威啤酒", "啤酒");
        ArrayList<Product> products = Lists.newArrayList(prod1, prod2, prod3, prod4, prod5);
        Map<String, Long> map = products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println(map);

    }

    @Test
    public void findFirst() {
        int i = IntStream.of(7, 2, 3, 4, 5).findFirst().getAsInt();
        // 7
        System.out.println(i);
    }

    @Test
    public void foreach() {
        //1 2 3 4 5
        IntStream.of(1, 2, 3, 4, 5).forEach(System.out::println);
    }

    @Test
    public void max() {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        Integer integer = list.stream().max(Integer::compareTo).get();
        System.out.println(integer);
    }

    @Test
    public void reduce() {
        List<String> strs = Arrays.asList("H", "E", "L", "L", "O");
        String concatReduce = strs.stream().reduce("", String::concat);
        System.out.println(concatReduce);
    }

    @Test
    public void toArray(){
        Object[] objects = Stream.of(1, 2, 3, 4, 5).toArray();
        String[] strings = Stream.of("A","B","C").toArray(String[]::new);
    }

    @Test
    public void concat(){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,3,2);
        Stream.concat(list1.stream(),list2.stream()).forEach(System.out::print);
    }
}
