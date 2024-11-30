package by.aston;

import by.aston.car.Car;
import by.aston.driver.Driver;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Car car = new Car() {};
        driver.openCar();
        System.out.println("Hello world!");
    }
}