package com.zlanle.strategy.promotion;

public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("优惠券抵扣结算");
    }
}
