package ru.netology;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private OrderService service;

    public UserInterface(OrderService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
            showMenu();
            handleInput(scanner.nextInt());
        }
    }

    private void showMenu() {
        System.out.println("\nМагазин:");
        System.out.println("1. Найти товар по ключевому слову");
        System.out.println("2. Найти товар по цене");
        System.out.println("3. Добавить товар в корзину");
        System.out.println("4. Посмотреть содержимое корзины");
        System.out.println("5. Завершить покупку");
        System.out.println("0. Выход\n");
        System.out.print("Выберите действие: ");
    }

    private void handleInput(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Введите ключевое слово: ");
                List<Product> results = service.searchProductsByKeyword(scanner.next());
                displayResults(results);
                break;
            case 2:
                System.out.print("Минимальная цена: ");
                double minPrice = scanner.nextDouble();
                System.out.print("Максимальная цена: ");
                double maxPrice = scanner.nextDouble();
                results = service.searchProductsByPriceRange(minPrice, maxPrice);
                displayResults(results);
                break;
            case 3:
                System.out.print("Введите ID продукта для добавления в корзину: ");
                service.addProductToCart(scanner.nextLong());
                break;
            case 4:
                System.out.println("Товары в корзине:");
                service.shoppingCart.getItems().forEach(
                        p -> System.out.printf("%s ($%.2f)\n", p.getName(), p.getPrice()));
                break;
            case 5:
                double totalCost = service.checkout();
                System.out.printf("Общая стоимость: $%.2f\nЗавершение покупки.\n", totalCost);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private void displayResults(List<Product> results) {
        if (!results.isEmpty()) {
            System.out.println("Найденные продукты:");
            results.forEach(p ->
                    System.out.printf("%d. %s ($%.2f)\n", p.getId(), p.getName(), p.getPrice()));
        } else {
            System.out.println("Нет результатов.");
        }
    }
}
