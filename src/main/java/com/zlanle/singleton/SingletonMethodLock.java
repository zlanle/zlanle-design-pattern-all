package com.zlanle.singleton;

public class SingletonMethodLock {

    /**
     * 持有私有的静态对象，防止被调用，初始化为空，为了延迟加载
     */
    private static SingletonMethodLock instance = null;

    /**
     * 私有构造方法，防止被实例化
     */
    private SingletonMethodLock(){}

    /**
     * synchronized关键字锁住的是这个对象，这样的用法，在性能上会有所下降，因为每次调用getInstance()，都要对对象上锁
     * @return
     */
    public static synchronized SingletonMethodLock getInstance(){
        if (instance == null){
            instance = new SingletonMethodLock();
        }
        return instance;
    }
}
