package com.zlanle.factory;

import com.zlanle.factory.Sender;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("我是发送短信的");
    }
}
