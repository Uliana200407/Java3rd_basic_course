package org.example;
import java.util.Arrays;
import java.util.Comparator;


class Car {
    private String brand;
    private String model;
    private int year;
    private double price;
    private int mileage;

    public Car(String brand, String model, int year, double price, int mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
    }

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

        Car[] cars = {
                new Car("Toyota", "Camry", 2018, 25000, 45000),
                new Car("Ford", "Focus", 2017, 18000, 35000),
                new Car("BMW", "X5", 2020, 55000, 20000),
                new Car("Audi", "A4", 2019, 30000, 30000),
                new Car("Honda", "Civic", 2016, 15000, 50000)
        };

        Arrays.sort(cars, Comparator.comparingDouble(Car::getPrice)
                .thenComparing(Comparator.comparingInt(Car::getMileage).reversed()));

        System.out.println("Sorted array of cars:");
        for (Car car : cars) {
            System.out.println(car);
        }

        Car targetCar = new Car("Ford", "Focus", 2017, 18000, 35000);
        boolean found = Arrays.stream(cars).anyMatch(car -> car.equals(targetCar));

        System.out.println("\nIs an identical car found? " + (found ? "Yes" : "No"));
    }
}
