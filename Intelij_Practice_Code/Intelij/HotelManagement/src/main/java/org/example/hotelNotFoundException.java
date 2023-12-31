package org.example;

public class hotelNotFoundException extends Exception
{
    hotelNotFoundException(String name)
    {
        System.out.println(name+" not found");
    }
}

