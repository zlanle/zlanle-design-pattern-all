package com.zlanle.delegate.simple;

public class DelegateTest {

    public static void main(String[] args) {

        /**
         * 客户请求（Boss）、委派者（Leader）、被委派者（Target)
         * 委派者要求持有被委派者的引用
         * 代理模式注重的是过程，委派模式注重的是结果
         * 策略模式注重的是可扩展，委派模式注重的是内部的灵活和复用
         * 委派模式的核心是：分发、调度、派遣
         * 委派模式就是静态代理和策略模式的一种特殊组合
         * */

        new Boss().command("架构",new Leader());

    }
}
