package ru.netology;

import java.util.List;

public interface SearchableProductRepository {
    List<Product> findProductsByName(String keyword);
    List<Product> findProductsByPriceRange(double minPrice, double maxPrice);
}
