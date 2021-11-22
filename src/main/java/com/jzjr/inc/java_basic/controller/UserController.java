package com.jzjr.inc.java_basic.controller;

import com.jzjr.inc.java_basic.annotation.LogService;
import com.jzjr.inc.java_basic.bean.Person;
import com.jzjr.inc.java_basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/hello")
    @LogService
    public String hello(@RequestParam("name") String name) {
        System.out.println("hello:"+name);
//        int i = 1 / 0;
        return "hello " + name;
    }

    @PostMapping("/http")
    public void doHttp(ServletRequest servletRequest, ServletResponse servletResponse) {
        userService.doHttp(servletRequest,servletResponse);
    }

    @PostMapping("/params")
    public void doParams(Person person) {
        System.out.println(person);
    }
}
