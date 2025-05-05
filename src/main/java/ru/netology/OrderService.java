package ru.netology;

import java.util.List;

public class OrderService {
    private SearchableProductRepository searchableRepository;
    private SingleProductRetriever singleProductRetriever;
    ShoppingCart shoppingCart;

    public OrderService(SearchableProductRepository searchableRepository,
                        SingleProductRetriever singleProductRetriever,
                        ShoppingCart shoppingCart) {
        this.searchableRepository = searchableRepository;
        this.singleProductRetriever = singleProductRetriever;
        this.shoppingCart = shoppingCart;
    }

    public List<Product> searchProductsByKeyword(String keyword) {
        return searchableRepository.findProductsByName(keyword);
    }

    public List<Product> searchProductsByPriceRange(double minPrice, double maxPrice) {
        return searchableRepository.findProductsByPriceRange(minPrice, maxPrice);
    }

    public void addProductToCart(long productId) {
        Product product = singleProductRetriever.findProductById(productId);
        if (product != null) {
            shoppingCart.addItem(product);
        }
    }

    public double checkout() {
        return shoppingCart.calculateTotalCost();
    }
}