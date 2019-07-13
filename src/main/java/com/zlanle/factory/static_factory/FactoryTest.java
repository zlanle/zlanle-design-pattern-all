package com.zlanle.factory.static_factory;

import com.zlanle.factory.Sender;

public class FactoryTest {

    public static void main(String[] args) {
        Sender mailSender = SendFactory.produceMail();
        mailSender.send();
        Sender smsSender = SendFactory.produceSms();
        smsSender.send();
    }
}
