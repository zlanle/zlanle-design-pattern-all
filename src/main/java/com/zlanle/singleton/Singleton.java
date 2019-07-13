package com.zlanle.singleton;

/**
 * 完美单例模式（使用内部类来维护单例的实现）
 * 线程安全、性能高
 */
public class Singleton {

    /** 私有构造方法，防止被实例化 */
   private Singleton(){}

    /**
     * 使用内部类来维护单例
     */
   private static class SingletonFactory{
       private static Singleton instance = new Singleton();
   }

    /**
     * 获取实例
     * @return
     */
   public static Singleton getInstance(){
       return SingletonFactory.instance;
   }
}
