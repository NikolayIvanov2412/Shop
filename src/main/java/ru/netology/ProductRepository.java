package ru.netology;

import java.util.List;

public interface ProductRepository {
    List<Product> findProductsByName(String keyword);
    List<Product> findProductsByPriceRange(double minPrice, double maxPrice);
    Product findProductById(long id);
}

