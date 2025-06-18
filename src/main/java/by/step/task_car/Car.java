package by.step.task_car;

import java.util.ArrayList;
import java.util.List;

// Абстрактный класс для автомобиля
abstract class Car implements Lockable, Drivable {
    protected Engine engine;
    protected List<Wheel> wheels;
    protected int seats;
    protected String licenseCategory;
    protected Key correctKey;
    protected boolean isLocked = true;
    protected boolean isEngineRunning = false;
    protected List<Passenger> passengers = new ArrayList<>();

    public Car(Engine engine, List<Wheel> wheels, int seats, String licenseCategory, Key correctKey) {
        this.engine = engine;
        this.wheels = wheels;
        this.seats = seats;
        this.licenseCategory = licenseCategory;
        this.correctKey = correctKey;
    }

    @Override
    public boolean unlock(Key key) {
        if (key.getId().equals(correctKey.getId())) {
            isLocked = false;
            return true;
        }
        return false;
    }

    @Override
    public void lock() {
        isLocked = true;
    }

    @Override
    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public void startEngine(Driver driver) {
        if (!isLocked && driver.getLicenseCategories().contains(licenseCategory)) {
            isEngineRunning = true;
            System.out.println("Двигатель запущен");
        } else {
            System.out.println("Не удалось запустить двигатель");
        }
    }

    @Override
    public void stopEngine() {
        isEngineRunning = false;
        System.out.println("Двигатель остановлен");
    }

    @Override
    public void drive() {
        if (isEngineRunning && !isLocked) {
            System.out.println("Автомобиль едет");
        } else {
            System.out.println("Автомобиль не может ехать");
        }
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < seats - 1) { // -1 для водителя
            passengers.add(passenger);
            System.out.println("Пассажир добавлен");
        } else {
            System.out.println("Нет свободных мест");
        }
    }

    public void refuel(FuelType fuelType) {
        if (fuelType == engine.getFuelType()) {
            System.out.println("Автомобиль заправлен");
        } else {
            System.out.println("Неверный тип топлива");
        }
    }
}
