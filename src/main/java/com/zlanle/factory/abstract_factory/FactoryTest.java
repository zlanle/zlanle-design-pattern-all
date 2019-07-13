package com.zlanle.factory.abstract_factory;

import com.zlanle.factory.Sender;

public class FactoryTest {

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender produce = provider.produce();
        produce.send();

        new SendTimelySmsFactory().produce().send();
    }
}
