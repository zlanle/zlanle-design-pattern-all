package com.zlanle.proxy.dynamic;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
import com.zlanle.proxy.dbroute.db.DynamicDataSourceEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceDynamicProxy  implements InvocationHandler {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

    private Object proxyObj;

    public Object getInstance(Object proxyObj){
        this.proxyObj = proxyObj;
        Class<?> clazz = proxyObj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before(args[0]);
        Object invoke = method.invoke(proxyObj,args);
        this.after();
        return invoke;
    }

    //proxyObj 应该是订单对象Order
    private void before(Object proxyObj){
        //进行数据源的切换
        System.out.println("Proxy before method");
        //约定优于配置
        try {
            Long time = (Long) proxyObj.getClass().getMethod("getCreateTime").invoke(proxyObj);
            Integer dbRouter = Integer.valueOf(simpleDateFormat.format(new Date(time)));
            System.out.println("静态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据");
            DynamicDataSourceEntity.set(dbRouter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void after(){
        System.out.println("Proxy after method");
        //还原成默认的数据源
        DynamicDataSourceEntity.restore();
    }
}
