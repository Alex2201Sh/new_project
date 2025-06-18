package by.step.task_car;

// Абстрактный класс для мотора
abstract class Engine {
    protected String name;
    protected double volume; // объем в литрах
    protected FuelType fuelType;

    public Engine(String name, double volume, FuelType fuelType) {
        this.name = name;
        this.volume = volume;
        this.fuelType = fuelType;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}
