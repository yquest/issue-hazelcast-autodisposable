package com.example;

public class RunnableExample implements Runnable{
    @Override
    public void run() {
        System.out.println("running "+getClass().getName());
    }
}
