package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class SimpleProductRepository implements SearchableProductRepository, SingleProductRetriever {
    private List<Product> products = new ArrayList<>();

    public SimpleProductRepository() {
        loadInitialData();
    }

    private void loadInitialData() {
        long[] ids = {1, 2, 3};
        String[] names = {"Phone X", "Tablet Y", "Laptop Z"};
        double[] prices = {999, 499, 1499};

        for (int i = 0; i < ids.length; i++) {
            products.add(new Product(ids[i], names[i], prices[i]));
        }
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