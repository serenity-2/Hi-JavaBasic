package com.jzjr.inc.java_basic.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogService {
  String code() default "";

  String name() default "";
}
