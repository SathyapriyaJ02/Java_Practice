package org.example;

public class Demo extends Thread {
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("Java");
            try
            {
                sleep(1000);
            }
            catch(Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
