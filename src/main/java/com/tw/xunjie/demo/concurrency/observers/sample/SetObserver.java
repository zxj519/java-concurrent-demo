package com.tw.xunjie.demo.concurrency.observers.sample;

/**
 * Created by xjzhou on 11/04/2017.
 */
public interface SetObserver<E> {
    void added(ObservableSet<E> set, E element);
}
