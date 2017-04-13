package com.tw.xunjie.demo.concurrency;

import com.tw.xunjie.demo.concurrency.utils.SampleUtil;

import java.util.Random;
import java.util.concurrent.*;

import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by xjzhou on 10/04/2017.
 */
public class CompletableFutureSample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        out.println("Main thread started [" + Thread.currentThread().getName() + "]");

        CompletableFuture asyncFuture = CompletableFuture.supplyAsync(() -> {
            out.println("  Async call started [" + Thread.currentThread().getName() + "]");
            Random r = new Random();
            boolean randomBoolean = r.nextBoolean();
            out.println("  Get random boolean " + randomBoolean);

            try {
                SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            out.println("  Async call finished.");
            return randomBoolean;
        }, executor).thenApply(CompletableFutureSample::apply).exceptionally(e -> e.getMessage()).thenAccept(s -> out.println("      " + s + " [" + Thread.currentThread().getName() + "]"));

        //asyncFuture.get();

        out.println("Main thread finished.");
    }

    public static String apply(boolean value) {
        out.println("    Convert boolean to String [" + Thread.currentThread().getName() + "]");
        return value ? "OK" : "NOT OK";
    }
}
