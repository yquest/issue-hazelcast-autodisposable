package com.example;

import java.io.Serializable;

public class RunnableExample implements Serializable, Runnable{
    @Override
    public void run() {
        System.out.println("running "+getClass().getName());
    }
}
