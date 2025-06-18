package by.step.task_car;

import java.util.List;

// Класс для водителя
class Driver {
    private int drivingExperience; // стаж в годах
    private List<String> licenseCategories;
    private List<Key> keys;

    public Driver(int drivingExperience, List<String> licenseCategories, List<Key> keys) {
        this.drivingExperience = drivingExperience;
        this.licenseCategories = licenseCategories;
        this.keys = keys;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public List<String> getLicenseCategories() {
        return licenseCategories;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void openAndStartCar(Car car) {
        for (Key key : keys) {
            if (car.unlock(key)) {
                System.out.println("Автомобиль открыт");
                car.startEngine(this);
                return;
            }
        }
        System.out.println("Нет подходящего ключа");
    }

    public void driveCar(Car car) {
        if (!car.isLocked() && car.isEngineRunning) {
            car.drive();
        } else {
            System.out.println("Не могу вести автомобиль");
        }
    }

    public void addPassengerToCar(Car car, Passenger passenger) {
        car.addPassenger(passenger);
    }

    public void refuelCar(Car car, FuelType fuelType) {
        car.refuel(fuelType);
    }
}
