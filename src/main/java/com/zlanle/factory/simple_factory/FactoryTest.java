package com.zlanle.factory.simple_factory;

import com.zlanle.factory.Sender;

public class FactoryTest {
    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
        Sender mail = sendFactory.produce("mail");
        mail.send();
        Sender sms = sendFactory.produce("sms");
        sms.send();
    }
}
