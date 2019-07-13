package com.zlanle.factory.method_factory;

import com.zlanle.factory.Sender;

public class FactoryTest {

    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
        Sender mailSender = sendFactory.produceMail();
        mailSender.send();
        Sender smsSend = sendFactory.productSms();
        smsSend.send();
    }
}
