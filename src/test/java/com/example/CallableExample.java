package com.example;

import java.util.concurrent.Callable;

public class CallableExample implements Callable<Void> {
    @Override
    public Void call() {
        System.out.println("running "+getClass().getName());
        return null;
    }
}
