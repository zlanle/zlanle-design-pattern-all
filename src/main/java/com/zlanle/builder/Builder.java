package com.zlanle.builder;

import com.zlanle.factory.MailSender;
import com.zlanle.factory.Sender;

import java.util.ArrayList;
import java.util.List;

public class Builder {

    private List<Sender> list = new ArrayList<>();

    public void produceMailSender(int count){
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }
}
