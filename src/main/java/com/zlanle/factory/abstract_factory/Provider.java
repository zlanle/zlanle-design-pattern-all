package com.zlanle.factory.abstract_factory;

import com.zlanle.factory.Sender;

public interface Provider {

    public Sender produce();
}
