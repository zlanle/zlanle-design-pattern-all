package com.zlanle.singleton;

/**
 * 普通单例模式
 * 线程不安全，在对线程下会出问题
 */
public class SingletonSimple {

    /**持有私有静态实例，防止被引用，初始化为空，是为了延迟加载*/
    private static SingletonSimple instance = null;

    /**私有构造函数，防止被实例化*/
    private SingletonSimple(){}

    /**
     * 静态工厂方法，对外提供访问，创建实例
     * @return
     */
    public static SingletonSimple getInstance(){
        if (instance == null){
            instance = new SingletonSimple();
        }
        return instance;
    }

    /**
     * 如果该对象备用于序列化，可以保证对象序列化前后一致
     * @return
     */
    public Object readResolve(){
        return instance;
    }
}
