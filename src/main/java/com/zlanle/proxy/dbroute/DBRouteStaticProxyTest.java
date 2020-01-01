package com.zlanle.proxy.dbroute;

import com.zlanle.proxy.dbroute.Order;
import com.zlanle.proxy.dbroute.OrderDao;
import com.zlanle.proxy.dbroute.OrderServiceImpl;
import com.zlanle.proxy.dbroute.proxy.OrderServiceDynamicProxy;
import com.zlanle.proxy.dbroute.proxy.OrderServiceStaticProxy;
import com.zlanle.proxy.dynamic.DBRouteDynamicProxyTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBRouteStaticProxyTest {

    public static void main(String[] args) throws ParseException {
        Order order = new Order();

        //order.setCreateTime(new Date().getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = simpleDateFormat.parse("2017/12/12");
        order.setCreateTime(date.getTime());

        OrderDao orderDao = new OrderDao();
        OrderServiceImpl orderService = new OrderServiceImpl(orderDao);
        //静态代理
//        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy(orderService);
 //       orderServiceStaticProxy.createOrder(order);
        //动态代理
        IOrderService orderService1 = (IOrderService)new OrderServiceDynamicProxy().getInstance(orderService);
        orderService1.createOrder(order);
    }
}
