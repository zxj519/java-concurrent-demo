package com.tw.xunjie.demo.concurrency.observers.sample;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * Created by xjzhou on 11/04/2017.
 */
public class SampleApp {
    public static void main(String[] args) throws Exception {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<Integer>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.print(element);
                if(element==23) {
                    set.removeObserver(this);
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
