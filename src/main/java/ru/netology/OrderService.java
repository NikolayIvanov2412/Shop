package ru.netology;

import java.util.List;

public class OrderService {
    private ProductRepository repository;
    ShoppingCart shoppingCart;

    public OrderService(ProductRepository repository, ShoppingCart shoppingCart) {
        this.repository = repository;
        this.shoppingCart = shoppingCart;
    }

    public List<Product> searchProductsByKeyword(String keyword) {
        return repository.findProductsByName(keyword);
    }

    public List<Product> searchProductsByPriceRange(double minPrice, double maxPrice) {
        return repository.findProductsByPriceRange(minPrice, maxPrice);
    }

    public void addProductToCart(long productId) {
        Product product = repository.findProductById(productId);
        if (product != null) {
            shoppingCart.addItem(product);
        }
    }

    public double checkout() {
        return shoppingCart.calculateTotalCost();
    }
}