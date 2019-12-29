package com.zlanle.proxy.dynamic.lanleproxy;

import java.lang.reflect.Method;

public class LanLeMeiPo implements LanLeInvocationHandler {

    private Object targer;

    public Object getInstance(Object target){
        this.targer = target;
        Class<?> aClass = target.getClass();
        return LanLeProxy.newProxyInstance(new LanLeClassLoader(),aClass.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object invoke = method.invoke(this.targer, args);
        this.after();
        return invoke;
    }

    private void before(){
        System.out.println("代理方法之前添加处理逻辑：");
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求,开始物色");
    }

    private void after(){
        System.out.println("代理方法之后添加处理逻辑：");
        System.out.println("好的话，准本办事");
    }
}
