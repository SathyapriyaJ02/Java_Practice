package org.example;

public class Product {

    int id ;
    String name ;
    double price;


    Product(int id , String name , double price)
    {
        this.id = id ;
        this.name = name ;
        this.price = price ;

    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }


}
