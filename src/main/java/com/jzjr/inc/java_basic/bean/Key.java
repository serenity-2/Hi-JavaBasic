package com.jzjr.inc.java_basic.bean;

import java.util.HashMap;

public class Key {
    private Integer id;

    public Key(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    //故意先注释掉equals和hashCode方法
     public boolean equals(Object o) {
     if (o == null || !(o instanceof Key))
     { return false; }
     else
     { return this.getId().equals(((Key) o).getId());}
     }

     public int hashCode()
     { return id.hashCode(); }

    public static void main(String[] args) {
        Key k1 = new Key(1);
        Key k2 = new Key(1);
        Key k3 = new Key(1);
        HashMap<Key, String> hm = new HashMap<>();
        hm.put(k1, "Key with id is 1");
        System.out.println(hm.get(k3));
    }
}
