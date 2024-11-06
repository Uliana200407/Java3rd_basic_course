package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GiftTest {
    private Gift gift;

    @BeforeEach
    public void setUp() {
        gift = new Gift();
        gift.addCandy(new ChocolateCandy("Dark Chocolate", 50, 20));
        gift.addCandy(new FruitCandy("Fruit Jelly", 30, 15));
        gift.addCandy(new CreamCandy("Vanilla Cream", 25, 10));
        gift.addCandy(new ChocolateCandy("Milk Chocolate", 45, 18));
    }

    @Test
    public void testTotalWeight() {
        double expectedWeight = 50 + 30 + 25 + 45;
        assertEquals(expectedWeight, gift.getTotalWeight(), 0.01, "Total weight should be correct.");
    }

    @Test
    public void testSortCandiesByWeight() {
        gift.sortCandiesByWeight();
        List<Candy> candies = gift.findCandiesByChocolateContent(0, 100);

        assertTrue(candies.get(0).getWeight() <= candies.get(1).getWeight(), "Candies should be sorted by weight in ascending order.");
        assertTrue(candies.get(1).getWeight() <= candies.get(2).getWeight(), "Candies should be sorted by weight in ascending order.");
        assertTrue(candies.get(2).getWeight() <= candies.get(3).getWeight(), "Candies should be sorted by weight in ascending order.");
    }

    @Test
    public void testFindCandiesByChocolateContent() {
        List<Candy> result = gift.findCandiesByChocolateContent(10, 70);

        assertEquals(2, result.size(), "Should find two candies with chocolate content between 10% and 70%.");
        assertTrue(result.stream().allMatch(candy -> candy.getChocolateContent() >= 10 && candy.getChocolateContent() <= 70),
                "All found candies should have chocolate content within the specified range.");
    }


    @Test
    public void testEmptyGift() {
        Gift emptyGift = new Gift();
        assertEquals(0, emptyGift.getTotalWeight(), "Total weight of an empty gift should be zero.");
    }

    @Test
    public void testAddCandy() {
        Gift testGift = new Gift();
        testGift.addCandy(new ChocolateCandy("Test Candy", 10, 5));
        assertEquals(10, testGift.getTotalWeight(), "Total weight should be equal to the weight of the added candy.");
    }

    @Test
    public void testToString() {
        String expectedOutput = "Gift contains:\n" +
                "Dark Chocolate: Weight=50.00g, Sugar=20g, Chocolate=70%\n" +
                "Fruit Jelly: Weight=30.00g, Sugar=15g, Chocolate=0%\n" +
                "Vanilla Cream: Weight=25.00g, Sugar=10g, Chocolate=0%\n" +
                "Milk Chocolate: Weight=45.00g, Sugar=18g, Chocolate=70%\n";

        assertEquals(expectedOutput.trim(), gift.toString().trim(), "The toString method should correctly display the gift's contents.");
    }
}
