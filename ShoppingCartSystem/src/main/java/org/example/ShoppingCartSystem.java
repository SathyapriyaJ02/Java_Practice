package org.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCartSystem {

    Map<Integer,Customer> customers = new HashMap<>();

    Map<Integer,Product> products = new HashMap<>();

    Map<Integer,ShoppingCart> cart = new HashMap<>();
    public void addProduct(int id , String name , double price )
    {
        products.put(id,new Product(id,name,price));
        System.out.println("Product Added");
        for(Map.Entry<Integer, Product> entry  : products.entrySet())
        {
            int key = entry.getKey();
            String vname = entry.getValue().getName();
            double vprice = entry.getValue().getPrice();

            System.out.println(key+" "+vname+" "+vprice);
        }
    }

    public void registerCustomer(int id ,String name)
    {
        customers.put(id,new Customer(id, name));
        System.out.println("User Added");
        System.out.println(customers);
    }



    public ShoppingCart getCustomerCart(int customerId)
    {
        System.out.println("Before adding ");
        for (Map.Entry<Integer, ShoppingCart> entry : cart.entrySet()) {
            int Id = entry.getKey();
            ShoppingCart shoppingCart = entry.getValue();

            System.out.println("Customer ID: " + Id);
            System.out.println("Items in Cart: " + shoppingCart.getItems());
            System.out.println("---------------------------");
        }
        if(!cart.containsKey(customerId))
        {
            cart.put(customerId,new ShoppingCart());
            System.out.println("After adding ");
            for (Map.Entry<Integer, ShoppingCart> entry : cart.entrySet()) {
                int Id = entry.getKey();
                ShoppingCart shoppingCart = entry.getValue();

                System.out.println("Customer ID: " + Id);
                System.out.println("Items in Cart: " + shoppingCart.getItems());
                System.out.println("---------------------------");
            }
        }

        return cart.get(customerId);
    }

}
