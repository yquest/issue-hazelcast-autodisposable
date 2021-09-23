package com.example;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class CallableExample implements Serializable, Callable<Void>{
    @Override
    public Void call() {
        System.out.println("running "+getClass().getName());
        return null;
    }
}
