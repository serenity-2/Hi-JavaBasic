package com.jzjr.inc.java_basic.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long id;

    private Integer num;

    private BigDecimal price;

    private String name;

    private String category;
}
