package com.zlanle.proxy.dbroute.proxy;

import com.zlanle.proxy.dbroute.db.DynamicDataSourceEntity;
import com.zlanle.proxy.dynamic.lanleproxy.LanLeClassLoader;
import com.zlanle.proxy.dynamic.lanleproxy.LanLeInvocationHandler;
import com.zlanle.proxy.dynamic.lanleproxy.LanLeProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceDynamicProxy implements LanLeInvocationHandler {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    private Object proxyObject;
    public Object getInstance(Object proxyObject){
        this.proxyObject = proxyObject;
        Class<?> clazz = proxyObject.getClass();
        return LanLeProxy.newProxyInstance(new LanLeClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        befor(args[0]);
        Object object = method.invoke(proxyObject, args);
        after();
        return object;
    }

    private void after() {
        System.out.println("动态代理之后方法处理逻辑：");
        //还原成默认的数据源
        DynamicDataSourceEntity.restore();
    }

    private void befor(Object object) {
        try {
            //进行数据源切换
            System.out.println("动态代理之前的方法处理逻辑：");
            //约定优于配置
            Method getCreateTime = object.getClass().getMethod("getCreateTime");
            Long time = (Long) getCreateTime.invoke(object);
            Integer dbRouter = Integer.valueOf(sdf.format(new Date()));
            System.out.println("动态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
            DynamicDataSourceEntity.set(dbRouter);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
