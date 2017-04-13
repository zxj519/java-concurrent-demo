package com.tw.xunjie.demo.concurrency.utils;

import java.util.concurrent.Callable;

import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by xjzhou on 10/04/2017.
 */
public class SampleUtil {
    public static Callable getCallable(){
         Callable<Integer> task = () -> {
            try {
                SECONDS.sleep(1);
                out.println("Executing task!");
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        return task;
    }
}
