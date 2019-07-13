package com.zlanle.singleton;

public class SingletonTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("实例化开始"+ finalI);
                    SingletonSimple instance = SingletonSimple.getInstance();
                    System.out.println(instance.hashCode());
                    System.out.println("实例化结束"+ finalI);
                }
            });
            thread.start();
        }
    }
}
