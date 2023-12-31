package org.example;


public class Main {
    public static void main(String[] args) {

        ShoppingCartSystem cart = new ShoppingCartSystem();

        cart.addProduct(1, "Laptop", 1000.00);
        cart.addProduct(2, "Phone", 2000.00);
        cart.registerCustomer(1, "John");


        ShoppingCart johnCart = cart.getCustomerCart(1);
        johnCart.addItems(cart.products.get(1), 2);
        johnCart.addItems(cart.products.get(2), 1);
        System.out.println("Total Cost: " + johnCart.calculateTotal());

        johnCart.removeItem(1);
    }
}