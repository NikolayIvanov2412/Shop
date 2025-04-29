package ru.netology;

public class ShopApplication {
    public static void main(String[] args) {
        ProductRepository productRepo = new SimpleProductRepository();
        ShoppingCart cart = new ShoppingCart();
        OrderService orderService = new OrderService(productRepo, cart);
        UserInterface ui = new UserInterface(orderService);

        ui.start();
    }
}