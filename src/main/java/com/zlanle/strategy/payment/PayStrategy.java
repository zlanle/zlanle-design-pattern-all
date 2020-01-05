package com.zlanle.strategy.payment;

import java.util.HashMap;
import java.util.Map;

public class PayStrategy {

    public static final String ALI_PAY = "ALI_PAY";
    public static final String JD_PAY = "JD_PAY";
    public static final String UNION_PAY = "UNION_PAY";
    public static final String WECHAT_PAY = "WECHAT_PAY";
    public static Map<String,Payment> PAY_STRATEGY_MAP = new HashMap<>();
    static {
        PAY_STRATEGY_MAP.put(ALI_PAY,new AliPay());
        PAY_STRATEGY_MAP.put(JD_PAY,new JDPay());
        PAY_STRATEGY_MAP.put(UNION_PAY,new UnionPay());
        PAY_STRATEGY_MAP.put(WECHAT_PAY,new WechatPay());
    }

    public static Payment getPayStrategy(String payKey){
        if(PAY_STRATEGY_MAP.containsKey(payKey))
            return PAY_STRATEGY_MAP.get(payKey);
        return PAY_STRATEGY_MAP.get(ALI_PAY);
    }
}
