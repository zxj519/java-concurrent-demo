package com.tw.xunjie.demo.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by xjzhou on 10/04/2017.
 */
public class SimpleSubThreadSample {
    public static void main(String[] args){
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }
}
