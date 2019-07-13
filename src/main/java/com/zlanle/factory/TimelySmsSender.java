package com.zlanle.factory;

public class TimelySmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("我是发送及时消息的");
    }
}
