package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Abstract class representing a generic candy.
 */
abstract class Candy {

    protected String name;
    protected double weight;
    protected int sugarContent;
    protected int chocolateContent;

    /**
     * Constructor to initialize a candy object with the specified attributes.
     *
     * @param name           the name of the candy.
     * @param weight         the weight of the candy in grams.
     * @param sugarContent   the sugar content of the candy in grams.
     * @param chocolateContent the chocolate content percentage in the candy.
     */
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

    /**
     * Returns a string representation of the candy.
     *
     * @return a formatted string with the candy's details.
     */
    @Override
    public String toString() {
        return String.format("%s: Weight=%.2fg, Sugar=%dg, Chocolate=%d%%", name, weight, sugarContent, chocolateContent);
    }
}

/**
 * Represents a chocolate candy, subclass of Candy.
 */
class ChocolateCandy extends Candy {

    /**
     * Constructor to initialize a ChocolateCandy object.
     *
     * @param name         the name of the candy.
     * @param weight       the weight of the candy in grams.
     * @param sugarContent the sugar content of the candy in grams.
     */
    public ChocolateCandy(String name, double weight, int sugarContent) {
        super(name, weight, sugarContent, 70); // Chocolate candies have 70% chocolate content by default
    }
}

/**
 * Represents a fruit-flavored candy, subclass of Candy.
 */
class FruitCandy extends Candy {

    /**
     * Constructor to initialize a FruitCandy object.
     *
     * @param name         the name of the candy.
     * @param weight       the weight of the candy in grams.
     * @param sugarContent the sugar content of the candy in grams.
     */
    public FruitCandy(String name, double weight, int sugarContent) {
        super(name, weight, sugarContent, 0); // Fruit candies have 0% chocolate content
    }
}

/**
 * Represents a cream candy, subclass of Candy.
 */
class CreamCandy extends Candy {

    /**
     * Constructor to initialize a CreamCandy object.
     *
     * @param name         the name of the candy.
     * @param weight       the weight of the candy in grams.
     * @param sugarContent the sugar content of the candy in grams.
     */
    public CreamCandy(String name, double weight, int sugarContent) {
        super(name, weight, sugarContent, 0); // Cream candies have 0% chocolate content
    }
}

/**
 * Represents a gift containing a collection of candies.
 */
class Gift {
    private List<Candy> candies = new ArrayList<>();

    /**
     * Adds a candy to the gift.
     *
     * @param candy the candy to be added.
     */
    public void addCandy(Candy candy) {
        candies.add(candy);
    }

    /**
     * Returns the total weight of all the candies in the gift.
     *
     * @return the total weight of the candies.
     */
    public double getTotalWeight() {
        double totalWeight = 0;
        for (Candy candy : candies) {
            totalWeight += candy.getWeight();
        }
        return totalWeight;
    }

    /**
     * Sorts the candies in the gift by their weight in ascending order.
     */
    public void sortCandiesByWeight() {
        candies.sort(Comparator.comparingDouble(Candy::getWeight));
    }

    /**
     * Finds candies in the gift with chocolate content within the specified range.
     *
     * @param min the minimum chocolate content (inclusive).
     * @param max the maximum chocolate content (inclusive).
     * @return a list of candies that meet the chocolate content criteria.
     */
    public List<Candy> findCandiesByChocolateContent(int min, int max) {
        List<Candy> result = new ArrayList<>();
        for (Candy candy : candies) {
            if (candy.getChocolateContent() >= min && candy.getChocolateContent() <= max) {
                result.add(candy);
            }
        }
        return result;
    }

    /**
     * Returns a string representation of all the candies in the gift.
     *
     * @return a formatted string with all the candy details.
     */
    @Override
    public String toString() {
        StringBuilder giftDetails = new StringBuilder();
        for (Candy candy : candies) {
            giftDetails.append(candy.toString()).append("\n");
        }
        return giftDetails.toString();
    }
}
