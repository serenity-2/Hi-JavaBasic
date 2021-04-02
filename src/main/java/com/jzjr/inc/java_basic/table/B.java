package com.jzjr.inc.java_basic.table;

public class B extends A{
    public B(String s) {
        System.out.println("B");;
    }
//    public B(String s){
//        System.out.println("B");
//    }

    public static void main(String[] args) {
        new B("c");
    }
}
