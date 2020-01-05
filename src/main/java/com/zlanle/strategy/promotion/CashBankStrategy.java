package com.zlanle.strategy.promotion;

public class CashBankStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销结算方式");
    }
}
