package com.zlanle.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {

    private static Map<String,PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();
    private static PromotionStrategy NON_PROMOTION = new EmptyStrategy();
    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY,new GroupBuyStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBANK,new CashBankStrategy());
    }

    private PromotionStrategyFactory(){}

    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }

    private interface  PromotionKey{
        String COUPON = "COUPON";
        String GROUPBUY = "GROUPBUY";
        String CASHBANK = "CASHBANK";
    }

}
