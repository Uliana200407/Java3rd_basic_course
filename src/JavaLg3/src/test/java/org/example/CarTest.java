package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
     void testCarInitialization() {
        Car car = new Car("Toyota", "Camry", 2018, 25000, 45000);
        assertEquals("Toyota", car.getBrand());
        assertEquals("Camry", car.getModel());
        assertEquals(2018, car.getYear());
        assertEquals(25000, car.getPrice());
        assertEquals(45000, car.getMileage());
    }

    @Test
    void testCarToString() {
        Car car = new Car("Toyota", "Camry", 2018, 25000, 45000);
        String expected = "Car{brand='Toyota', model='Camry', year=2018, price=25000.0, mileage=45000}";
        assertEquals(expected, car.toString());
    }

    @Test
    void testCarEquality() {
        Car car1 = new Car("Toyota", "Camry", 2018, 25000, 45000);
        Car car2 = new Car("Toyota", "Camry", 2018, 25000, 45000);
        Car car3 = new Car("Honda", "Civic", 2016, 15000, 50000);

        assertEquals(car1, car2, "Cars with identical attributes should be equal");
        assertNotEquals(car1, car3, "Cars with different attributes should not be equal");
    }

    @Test
    void testSortingCars() {
        Car[] cars = {
                new Car("Toyota", "Camry", 2018, 25000, 45000),
                new Car("Ford", "Focus", 2017, 18000, 35000),
                new Car("BMW", "X5", 2020, 55000, 20000),
                new Car("Audi", "A4", 2019, 30000, 30000),
                new Car("Honda", "Civic", 2016, 15000, 50000)
        };

        Arrays.sort(cars, Comparator.comparingDouble(Car::getPrice)
                .thenComparing(Comparator.comparingInt(Car::getMileage).reversed()));

        assertEquals("Honda", cars[0].getBrand());
        assertEquals(15000, cars[0].getPrice());
        assertEquals(50000, cars[0].getMileage());

        assertEquals("Ford", cars[1].getBrand());
        assertEquals(18000, cars[1].getPrice());
        assertEquals(35000, cars[1].getMileage());
    }

    @Test
    void testCarSearch() {
        Car[] cars = {
                new Car("Toyota", "Camry", 2018, 25000, 45000),
                new Car("Ford", "Focus", 2017, 18000, 35000),
                new Car("BMW", "X5", 2020, 55000, 20000),
                new Car("Audi", "A4", 2019, 30000, 30000),
                new Car("Honda", "Civic", 2016, 15000, 50000)
        };

        Car targetCar = new Car("Ford", "Focus", 2017, 18000, 35000);
        boolean found = Arrays.stream(cars).anyMatch(car -> car.equals(targetCar));

        assertTrue(found, "Target car should be found in the array");

        Car nonExistentCar = new Car("Tesla", "Model S", 2021, 80000, 10000);
        boolean notFound = Arrays.stream(cars).noneMatch(car -> car.equals(nonExistentCar));

        assertTrue(notFound, "Non-existent car should not be found in the array");
    }
}
