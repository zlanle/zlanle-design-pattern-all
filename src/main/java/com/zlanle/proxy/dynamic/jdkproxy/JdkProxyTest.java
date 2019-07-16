package com.zlanle.proxy.dynamic.jdkproxy;

import com.zlanle.proxy.statical.demo1.Person;

public class JdkProxyTest {

    public static void main(String[] args) {
        Person instance = (Person) new JdkMeiPo().getInstance(new Gril());
        instance.findLove();
        instance.buyBooks();
    }
}
