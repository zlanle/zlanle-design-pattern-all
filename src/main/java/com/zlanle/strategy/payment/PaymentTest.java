package com.zlanle.strategy.payment;

import java.util.Currency;
import java.util.Date;

public class PaymentTest {

    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        Order order = new Order("123", millis+"",600);
        PayState payState = order.pay(PayStrategy.ALI_PAY);
        System.out.println(payState.toString());
    }
}
