package com.zlanle.delegate.simple;

public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是A员工负责处理加密开发");
    }
}
