package com.zlanle.strategy.payment;

public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    public double queryBalance(String uid) {
        return 300;
    }
}
