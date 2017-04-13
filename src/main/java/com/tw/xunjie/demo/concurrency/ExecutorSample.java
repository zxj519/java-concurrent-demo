package com.tw.xunjie.demo.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.System.err;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by xjzhou on 10/04/2017.
 */
public class ExecutorSample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            try {
                SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println("Hello " + threadName);
        });

        try {
            out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, SECONDS);
        } catch (InterruptedException e) {
            err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            out.println("shutdown finished");
        }
    }
}
