package com.zlanle.proxy.dynamic;

import com.zlanle.proxy.dbroute.IOrderService;
import com.zlanle.proxy.dbroute.Order;
import com.zlanle.proxy.dbroute.OrderDao;
import com.zlanle.proxy.dbroute.OrderServiceImpl;
import com.zlanle.proxy.dynamic.OrderServiceDynamicProxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBRouteDynamicProxyTest {

    public static void main(String[] args) throws ParseException {
        Order order = new Order();

        order.setCreateTime(new Date().getTime());
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = simpleDateFormat.parse("2017/12/12");
        order.setCreateTime(date.getTime());*/
        IOrderService orderService1 = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderServiceImpl(new OrderDao()));
        orderService1.createOrder(order);
    }
}
