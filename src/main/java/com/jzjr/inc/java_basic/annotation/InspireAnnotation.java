package com.jzjr.inc.java_basic.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface InspireAnnotation {
  public String name();
  int age() default 24;
  int[] arr();
}
