package com.zlanle.proxy.dynamic.lanleproxy;

import com.zlanle.proxy.dynamic.jdkproxy.Gril;
import com.zlanle.proxy.statical.demo1.Person;

public class LanLeProxyTest {

    public static void main(String[] args) {
        try {
            /** 媒婆作为中间人，说媒之前，先找寻有要求的女方，然后了解女方要求，找到之后通知女方*/
            Person person = (Person) new LanLeMeiPo().getInstance(new Gril());
            person.findLove();
            System.out.println(person.getClass());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
