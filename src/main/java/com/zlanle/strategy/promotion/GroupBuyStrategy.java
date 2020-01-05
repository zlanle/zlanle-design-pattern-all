package com.zlanle.strategy.promotion;

public class GroupBuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团购买，满20人，享受团购价");
    }
}
