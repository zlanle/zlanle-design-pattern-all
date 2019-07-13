package com.zlanle.factory.abstract_factory;

import com.zlanle.factory.Sender;
import com.zlanle.factory.TimelySmsSender;

public class SendTimelySmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new TimelySmsSender();
    }
}
