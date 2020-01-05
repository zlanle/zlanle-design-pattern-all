package com.zlanle.strategy.payment;

public class Order {

    private String uId;
    private String orderId;
    private double amount;

    public Order(String uId, String orderId, double amount) {
        this.uId = uId;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay(String payKey){
        Payment payment = PayStrategy.getPayStrategy(payKey);
        String data = "支付方式【"+payment.getName() + "】，支付金额【"+amount+"】"+"订单ID【"+ orderId +"】";
        return payment.pay(uId,amount,data);
    }
}
