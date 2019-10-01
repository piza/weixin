package com.zyzl;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestExpired {

    private final AtomicBoolean tokenRefreshing = new AtomicBoolean(false);

    public void test(){
        long now = System.currentTimeMillis();
        long time = now - 1569567802847l;


        System.out.println("now = "+now);
        System.out.println("time = "+time);
        System.out.println(time > 7100000);
        System.out.println(this.tokenRefreshing.compareAndSet(false, true));

    }

    public static void main(String[] args) {
        TestExpired testExpired=new TestExpired();
        testExpired.test();
    }
}
