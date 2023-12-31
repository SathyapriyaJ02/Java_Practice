package org.example;

public class Test extends Thread {
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("World");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
