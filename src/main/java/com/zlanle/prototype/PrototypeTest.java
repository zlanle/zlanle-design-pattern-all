package com.zlanle.prototype;

public class PrototypeTest {

    public static void main(String[] args) {
        SunWuKong obj = new SunWuKong();
        SunWuKong cory = obj.shallowClone(obj);
        System.out.println("浅复制：" + (obj.jinGuBang == cory.jinGuBang));

        SunWuKong sunWuKong = new SunWuKong();
        SunWuKong clone = (SunWuKong) sunWuKong.clone();
        System.out.println("深复制：" + (sunWuKong.jinGuBang == clone.jinGuBang));

    }
}
