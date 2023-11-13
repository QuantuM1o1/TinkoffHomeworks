package edu.hw3.Task6;

import java.util.Comparator;

public class Stock {
    private final String name;
    private final Integer price;

    public Stock(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Comparator<Stock> priceComparator = Comparator.comparing(stock -> stock.price);

    public String getName() {
        return name;
    }
}

