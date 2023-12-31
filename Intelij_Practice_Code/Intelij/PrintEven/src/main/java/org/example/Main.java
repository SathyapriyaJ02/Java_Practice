package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        Random rand = new Random();
        int sum = 0;
        List<Integer> e = new ArrayList<>();
        for(int i =0;i<=50;i++) {
            e.add((int) (Math.random() * 100));
            if (e.get(i) % 2 == 0) {
                int count = e.get(i) * 2;
                sum += count;

            }
        }
        System.out.println(sum);
    }
}