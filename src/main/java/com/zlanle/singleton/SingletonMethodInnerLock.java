package com.zlanle.singleton;

public class SingletonMethodInnerLock {

    /**
     * 持有私有的静态对象，防止被调用，初始化为空，为了延迟加载
     */
    private static SingletonMethodInnerLock instance = null;

    /**
     * 私有构造方法，防止被实例化
     */
    private SingletonMethodInnerLock(){}

    /**
     * 内部添加锁synchronized，实际上，对象只有在第一次初始化的时候加锁就可以了
     * 当在调用的时候不需要加锁，只有在对象instance==null，并初始化对象的时候才加锁，性能有一定的提升
     * @return
     */
    public static SingletonMethodInnerLock getInstance(){
        if (instance == null){
            synchronized (instance){
                if (instance == null){
                    instance = new SingletonMethodInnerLock();
                }
            }
        }
        return instance;
    }
}
