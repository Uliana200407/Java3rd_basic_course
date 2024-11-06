package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

abstract class Candy {
    protected String name;
    protected double weight;
    protected int sugarContent;
    protected int chocolateContent;

    public Candy(String name, double weight, int sugarContent, int chocolateContent) {
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
        this.chocolateContent = chocolateContent;
    }

    public double getWeight() {
        return weight;
    }

    public int getChocolateContent() {
        return chocolateContent;
    }

    @Override
    public String toString() {
        return String.format("%s: Weight=%.2fg, Sugar=%dg, Chocolate=%d%%", name, weight, sugarContent, chocolateContent);
    }
}

class ChocolateCandy extends Candy {
    public ChocolateCandy(String name, double weight, int sugarContent) {
        super(name, weight, sugarContent, 70);
    }
}

class FruitCandy extends Candy {
    public FruitCandy(String name, double weight, int sugarContent) {
        super(name, weight, sugarContent, 0);
    }
}

class CreamCandy extends Candy {
    public CreamCandy(String name, double weight, int sugarContent) {
        super(name, weight, sugarContent, 0);
    }
}

class Gift {
    private List<Candy> candies = new ArrayList<>();

    public void addCandy(Candy candy) {
        candies.add(candy);
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Candy candy : candies) {
            totalWeight += candy.getWeight();
        }
        return totalWeight;
    }

    public void sortCandiesByWeight() {
        candies.sort(Comparator.comparingDouble(Candy::getWeight));
    }

    public List<Candy> findCandiesByChocolateContent(int min, int max) {
        List<Candy> result = new ArrayList<>();
        for (Candy candy : candies) {
            if (candy.getChocolateContent() >= min && candy.getChocolateContent() <= max) {
                result.add(candy);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Gift contains:\n");
        for (Candy candy : candies) {
            sb.append(candy).append("\n");
        }
        return sb.toString();
    }
}

public class CandyGiftApp {
    public static void main(String[] args) {
        try {
            Gift gift = new Gift();

            gift.addCandy(new ChocolateCandy("Dark Chocolate", 50, 20));
            gift.addCandy(new FruitCandy("Fruit Jelly", 30, 15));
            gift.addCandy(new CreamCandy("Vanilla Cream", 25, 10));
            gift.addCandy(new ChocolateCandy("Milk Chocolate", 45, 18));

            System.out.println("Before Sorting:");
            System.out.println(gift);

            gift.sortCandiesByWeight();
            System.out.println("After Sorting by Weight:");
            System.out.println(gift);

            List<Candy> chocolateCandies = gift.findCandiesByChocolateContent(10, 70);
            System.out.println("Candies with Chocolate Content between 10% and 70%:");
            for (Candy candy : chocolateCandies) {
                System.out.println(candy);
            }

            System.out.printf("Total Weight of Gift: %.2fg\n", gift.getTotalWeight());

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
