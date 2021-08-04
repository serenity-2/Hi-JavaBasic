package com.jzjr.inc.java_basic;

import com.jzjr.inc.java_basic.bean.Person;
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
        // paralleStream并行流
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

    /**
     * peek与map的区别是
     * peek的参数是一个消费者，当传入的不是消费者时，peek将不生效，peek返回的流是是原始的流，不对流里面的元素产生变化
     * map的参数是一个函数，这个函数将作用于流中每个元素，map操作结束后流中的元素可以发生变化，也就是一个新的流了
     */
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
        // 求和的2种方式
        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6);
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        Optional<Integer> sum3 = list.stream().reduce((a, b) -> {
            return Integer.sum(a, b);
        });
//        List<String> strs = Arrays.asList("H", "E", "L", "L", "O");
//        Optional<String> concatReduce = strs.stream().reduce((s, c) ->{
//            String sc = s.concat("-").concat(c);
//            return sc;
//        });
//        System.out.println(concatReduce.get());
    }

    @Test
    public void toArray() {
        Object[] objects = Stream.of(1, 2, 3, 4, 5).toArray();
        String[] strings = Stream.of("A", "B", "C").toArray(String[]::new);
    }

    @Test
    public void concat() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 3, 2);
        Stream.concat(list1.stream(), list2.stream()).forEach(System.out::print);
    }

    @Test
    public void stringOperating() {
        String str = "1,2,3,4,5";
        String[] split = str.split(",");
        System.out.println(str.substring(1));
        System.out.println(str.substring(0, 3));
    }

    @Test
    public void findMaxString() {
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());
    }

    @Test
    public void flatmap() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());
        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + listNew);
    }

    @Test
    public void reduceTest() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        //求工资之和 一
        Optional<Integer> optional = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println(optional.get());
        //求工资之和 二
        Integer sum2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);
        System.out.println(sum2);
    }

    /**
     * reduce的第三种重载方法
     * U> U reduce(U identity,
     * BiFunction<U, ? super T, U> accumulator,
     * BinaryOperator<U> combiner);
     * 第一个参数：给定的一个初始值(类型U)，该值同时也是实际返回实例的数据类型(类型U)
     * 第二个参数：累加器，通过类型为U和? super T的两个输入值计算得到一个U类型的结果返回
     * 第三个参数：如果使用了parallelStream，reduce的操作是并发执行的，为了避免竞争，每个reduce线程都会有独立的result
     * combiner的作用是合并每个result得到独立的结果，在非并行流中，该参数不生效
     */
    @Test
    public void reduceTest2() {
        ArrayList<Integer> list = new ArrayList<>();
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        ArrayList<Integer> newList = integerStream.reduce(list, (a, b) -> {
            //list会作为a的第一个参数
            System.out.println("a=\t" + a);
            //b的第一个参数是流中第一个元素
            System.out.println("b=\t" + b);
            list.add(b);
            System.out.println("list\t" + list);
            //这里返回必须是a，因为a是初始值list的类型，返回值和初始值类型要相同
            return a;
            //这里因为是非并行流，给null或a或b都没有影响
        }, (a, b) -> null);
        System.out.println(newList);
    }

    @Test
    public void copy() {
        List<Integer> list = Arrays.asList(1, 4, 5, 6, 7);
        ArrayList<Object> newList = new ArrayList<>();
        List<Object> list1 = list.stream().filter(x -> x > 5).reduce(newList, (a, b) -> {
            newList.add(b);
            return a;
        }, (a, b) -> null);
        System.out.println(list);
    }

    @Test
    public void branch() {
        System.out.println("wuhahawuhahawuhahahaha");
    }

    @Test
    public void change() {
        System.out.println("only change can be  forever");
    }


}