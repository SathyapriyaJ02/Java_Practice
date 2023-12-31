package org.example;

public class Main {
    public static void main(String[] args) {
        Demo d = new Demo();
        Test t =new Test();
        d.start();
        t.start();
        System.out.println(d.getName());
        System.out.println(t.getName());

    }
}