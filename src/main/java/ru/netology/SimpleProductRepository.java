package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class SimpleProductRepository implements SearchableProductRepository, SingleProductRetriever {
    private List<Product> products = new ArrayList<>();

    public SimpleProductRepository() {
        // Продукты фиксированы для демонстрации.
        products.add(new Product(1, "Phone X", 999));
        products.add(new Product(2, "Tablet Y", 499));
        products.add(new Product(3, "Laptop Z", 1499));
    }

    @Override
    public List<Product> findProductsByName(String keyword) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().contains(keyword)) {
                foundProducts.add(p);
            }
        }
        return foundProducts;
    }

    @Override
    public List<Product> findProductsByPriceRange(double minPrice, double maxPrice) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product p : products) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                foundProducts.add(p);
            }
        }
        return foundProducts;
    }

    @Override
    public Product findProductById(long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}