package com.zlanle.proxy.dynamic.lanleproxy;

import java.lang.reflect.Method;

public interface LanLeInvocationHandler {

    Object invoke(Object proxy,Method method,Object[] args) throws Throwable;
}
