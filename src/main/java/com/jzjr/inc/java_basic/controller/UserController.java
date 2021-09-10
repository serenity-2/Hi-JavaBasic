package com.jzjr.inc.java_basic.controller;

import com.jzjr.inc.java_basic.annotation.LogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/hello")
    @LogService
    public String hello(@RequestParam("name") String name) {
        System.out.println("hello:"+name);
        int i = 1 / 0;
        return "hello Lily";
    }
}
