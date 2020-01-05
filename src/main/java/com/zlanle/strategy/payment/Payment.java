package com.zlanle.strategy.payment;

public abstract class Payment {

    /**支付方式*/
    public abstract String getName();
    /**余额查询*/
    public abstract double queryBalance(String uid);
    /**扣款支付*/
    public PayState pay(String uid,double amount,String data){
        if (queryBalance(uid) >= amount)
            return new PayState(200,data,"支付成功");
        return new PayState(500,data,"支付失败，余额不足");
    }
}
