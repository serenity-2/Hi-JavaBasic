package com.jzjr.inc.java_basic;

import com.jzjr.inc.java_basic.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
public class OptionalTest {
    /**
     * optional类
     */
    @Test
    public void print1() {
        //创建一个空的optional
        Optional<Object> empty = Optional.empty();
        //java.util.NoSuchElementException: No value present
        empty.get();
    }

    @Test
    public void print2() {
        //创建一个包含值的optional，不能传入null类型
        Optional<User> optionalUser = Optional.of(new User("Daisy", 24));
        User user = optionalUser.get();

        User user1 = null;
        Optional<User> user2 = Optional.of(user1);
        //java.lang.NullPointerException
        System.out.println(user2.get());
    }

    @Test
    public void print3() {
        //创建一个包含值的optional，可以传入null类型
        User user = null;
        Optional<User> user1 = Optional.ofNullable(user);
        //Optional.empty
        System.out.println(user1);
    }

    @Test
    public void print4() {
        //ifPresent 如果存在一个值，则使用该值调用指定的使用者，否则空指针异常
        User user = new User("daisy", 24);
        Optional<User> optionalUser = Optional.of(user);
        optionalUser.ifPresent(user1 -> {
            assertEquals(user1.getUsername(), "moko");
        });
    }

    @Test
    public void print5() {
        //orElse 返回默认值，如果有值则返回该值，否则返回传递给它的参数值
        User user = null;
        User user1 = Optional.ofNullable(user).orElse(new User("Daisy", 24));
        //User{username='Daisy', age=24}
        System.out.println(user1);
    }

    /**
     * orElse与orElseGet的区别
     * orElse：不管Optional是否有值，orElse都会执行
     * orElseGet：当Optional没有值是会执行，有值时则不会执行
     */
    @Test
    public void print6() {
        User user = new User("moko", 23);
        //当对象为空时都返回默认对象
        log.info("Using orElse");
        User result = Optional.ofNullable(user).orElse(createNewUser());
        log.info("Using orElseGet");
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    private User createNewUser() {
        log.info("Creating New User");
        return new User("extra@gmail.com", 24);
    }

    @Test
    public void print7() {
        User user = new User("john@gmail.com", 24);
        log.info("Using orElse");
        //orElse即使有值也会执行形参方法
        User result = Optional.ofNullable(user).orElse(createNewUser());
        log.info("Using orElseGet");
        //orElseGet有值不会执行传入的supplier函数
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    @Test
    public void print8() {
        //orElseThrow 在对象为空时抛出异常
        User user = null;
        try {
            User result = Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void print9(){
        User user = new User("Anne", 25);
        String name = Optional.ofNullable(user).map(User::getUsername).orElse("Anbe");
        assertEquals(name, user.getUsername());
    }
}
