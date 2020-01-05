package com.zlanle.strategy.promotion;

public class PromotionTest {

    public static void main(String[] args){
        //PromotionActivity promotionActivity = new PromotionActivity(new GroupBuyStrategy());
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy("CASHBANK"));
        promotionActivity.execute();
    }
}
