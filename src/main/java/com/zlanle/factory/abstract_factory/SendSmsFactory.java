package com.zlanle.factory.abstract_factory;

import com.zlanle.factory.Sender;
import com.zlanle.factory.SmsSender;

public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
