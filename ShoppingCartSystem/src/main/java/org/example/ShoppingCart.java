package org.example;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    Map<Product,Integer> cart = new HashMap<>();


    public void addItems(Product product,int quantity)
    {
        cart.put(product,cart.getOrDefault(product,0)+quantity);
        System.out.println("Added");

    }

    public void removeItem(int productID)
    {
        cart.entrySet().removeIf(entry -> entry.getKey().getId()==productID);
        System.out.println("Removed");
        for(Map.Entry<Product,Integer> entry  : cart.entrySet())
        {
            int id = entry.getKey().getId();
            System.out.println("asdf "+id);
        }
    }

    public double calculateTotal()
    {
        double total = 0.0;

        for(Map.Entry<Product,Integer> entry : cart.entrySet() )
        {
            double price = entry.getKey().getPrice();

            int quantity = entry.getValue();

            total = price*quantity;
        }

        return total;
    }


    public String getItems() {
        return cart.toString();
    }
}
