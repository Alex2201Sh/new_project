package by.step.task_car;

import java.util.ArrayList;
import java.util.List;


// Пример использования
public class Main {
    public static void main(String[] args) {
        // Создаем компоненты для автомобиля
        Engine engine = new Engine("V6", 3.5, FuelType.GASOLINE) {};
        List<Wheel> wheels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            wheels.add(new Wheel("Michelin", 17, Season.ALL_SEASON) {});
        }
        Key carKey = new Key("sedan123");

        // Создаем автомобиль
        Car sedan = new Sedan(engine, wheels, 5, "B", carKey);

        // Создаем водителя
        List<String> licenses = new ArrayList<>();
        licenses.add("B");
        List<Key> keys = new ArrayList<>();
        keys.add(carKey);
        Driver driver = new Driver(5, licenses, keys);

        // Создаем пассажира
        Passenger passenger = new Passenger("Иван");

        // Действия водителя
        driver.openAndStartCar(sedan);
        driver.addPassengerToCar(sedan, passenger);
        driver.driveCar(sedan);
        driver.refuelCar(sedan, FuelType.GASOLINE);
    }
}