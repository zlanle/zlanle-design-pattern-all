package com.zlanle.proxy.dbroute;

public class OrderServiceImpl implements IOrderService {

    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderServiceImpl调用OrderDao创建订单成功");
        return orderDao.insert(order);
    }
}
