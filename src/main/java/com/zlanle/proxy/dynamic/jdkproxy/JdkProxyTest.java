package com.zlanle.proxy.dynamic.jdkproxy;

import com.zlanle.proxy.statical.demo1.Person;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JdkProxyTest {

    public static void main(String[] args) {
        Person instance = (Person) new JdkMeiPo().getInstance(new Gril());
        instance.findLove();
        //instance.buyBooks();
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E://gupao_workspace//$Proxy0.class");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
