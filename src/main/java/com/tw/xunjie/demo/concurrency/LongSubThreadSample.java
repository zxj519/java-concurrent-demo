package com.tw.xunjie.demo.concurrency;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * Created by xjzhou on 10/04/2017.
 */
public class LongSubThreadSample {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                out.println("Foo " + name);
                SECONDS.sleep(1);
                out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
