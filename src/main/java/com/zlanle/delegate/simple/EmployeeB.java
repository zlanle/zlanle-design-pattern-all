package com.zlanle.delegate.simple;

public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是A员工负责处理架构开发");
    }
}
