package ru.netology;

public class ShopApplication {
    public static void main(String[] args) {
        SimpleProductRepository simpleRepository = new SimpleProductRepository();

        SearchableProductRepository searchableRepository = simpleRepository;
        SingleProductRetriever singleProductRetriever = simpleRepository;

        ShoppingCart cart = new ShoppingCart();
        OrderService orderService = new OrderService(searchableRepository, singleProductRetriever, cart);
        UserInterface ui = new UserInterface(orderService);

        ui.start();
    }
}