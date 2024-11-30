package org.example;

import java.util.Arrays;
import java.util.Comparator;

class Car {
    private String brand;
    private String model;
    private int year;
    private double price;
    private int mileage;

    /**
     * Constructor to initialize a Car object with the provided details.
     *
     * @param brand   the brand of the car.
     * @param model   the model of the car.
     * @param year    the manufacturing year of the car.
     * @param price   the price of the car.
     * @param mileage the mileage of the car.
     */
    public Car(String brand, String model, int year, double price, int mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
    }

    // Getter methods for all fields
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    /**
     * Returns a string representation of the Car object.
     *
     * @return a string with details of the car.
     */
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", mileage=" + mileage +
                '}';
    }

    /**
     * Compares this Car object to another Car object for equality.
     *
     * @param obj the object to be compared.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car that = (Car) obj;
        return year == that.year &&
                Double.compare(that.price, price) == 0 &&
                mileage == that.mileage &&
                brand.equals(that.brand) &&
                model.equals(that.model);
    }
}

public class Lab3 {

    public static void main(String[] args) {
        // Initialize an array of Car objects
        Car[] cars = {
                new Car("Toyota", "Camry", 2018, 25000, 45000),
                new Car("Ford", "Focus", 2017, 18000, 35000),
                new Car("BMW", "X5", 2020, 55000, 20000),
                new Car("Audi", "A4", 2019, 35000, 25000)
        };

        // Sort cars by year of manufacturing (ascending)
        Arrays.sort(cars, Comparator.comparingInt(Car::getYear));
        System.out.println("Cars sorted by year of manufacture:");
        for (Car car : cars) {
            System.out.println(car);
        }

        // Sort cars by price (descending)
        Arrays.sort(cars, Comparator.comparingDouble(Car::getPrice).reversed());
        System.out.println("\nCars sorted by price (highest first):");
        for (Car car : cars) {
            System.out.println(car);
        }

        // Find the car with the lowest mileage
        Car lowestMileageCar = Arrays.stream(cars)
                .min(Comparator.comparingInt(Car::getMileage))
                .orElseThrow(() -> new RuntimeException("No cars found"));
        System.out.println("\nCar with the lowest mileage: " + lowestMileageCar);
    }
}
