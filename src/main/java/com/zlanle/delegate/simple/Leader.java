package com.zlanle.delegate.simple;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee{

    Map<String,IEmployee> targets = new HashMap<>();

    public Leader(){
        targets.put("加密",new EmployeeA());
        targets.put("架构",new EmployeeB());
    }

    @Override
    public void doing(String command){
        targets.get(command).doing(command);
    }
}
