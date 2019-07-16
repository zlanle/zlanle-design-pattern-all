package com.zlanle.proxy.dynamic.jdkproxy;

import com.zlanle.proxy.statical.demo1.Person;

public class Gril implements Person {

    @Override
    public void findLove() {
        System.out.println("高富帅、八块腹肌、身高180cm");
    }

    @Override
    public void buyBooks() {
        System.out.println("如何找个高富帅");
    }
}
