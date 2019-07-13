package com.zlanle.prototype;

import java.io.Serializable;

public class JinGuBang implements Serializable {

    private int h = 100;
    private int d = 10;

    public JinGuBang(){
        this.h = h;
        this.d = d;
    }

    public void big(){
        this.h *= 2;
        this.d *= 2;
    }
}
