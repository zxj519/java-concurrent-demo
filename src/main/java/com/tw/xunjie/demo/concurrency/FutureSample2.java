package com.tw.xunjie.demo.concurrency;

import com.tw.xunjie.demo.concurrency.utils.SampleUtil;

import java.util.concurrent.*;

import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by xjzhou on 10/04/2017.
 */
public class FutureSample2 {
    public static void main(String[] args){

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(SampleUtil.getCallable());

        out.println("future done? " + future.isDone());
        out.println("future done? " + future.isDone());

        try {
            SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        out.println("future done? " + future.isDone());
    }
}
