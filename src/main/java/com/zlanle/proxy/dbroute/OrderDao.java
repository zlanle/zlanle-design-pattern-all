package com.zlanle.proxy.dbroute;

public class OrderDao {

    public int insert(Order order){
        System.out.println("OrderDao创建订单成功");
        return 1;
    }

}
