package com.zlanle.proxy.dbroute.proxy;

import com.zlanle.proxy.dbroute.db.DynamicDataSourceEntity;
import com.zlanle.proxy.dbroute.IOrderService;
import com.zlanle.proxy.dbroute.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements IOrderService {

    /**日期格式化*/
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
    private IOrderService iOrderService;

    public OrderServiceStaticProxy(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    @Override
    public int createOrder(Order order) {
        Long createTime = order.getCreateTime();
        String longTime = simpleDateFormat.format(new Date(createTime));
        Integer dbRouter = Integer.valueOf(longTime);
        System.out.println("静态代理类自动分配到【DB_】"+dbRouter+"】数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);
        this.iOrderService.createOrder(order);
        DynamicDataSourceEntity.restore();
        return 0;
    }
}
