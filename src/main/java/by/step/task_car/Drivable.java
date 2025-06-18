package by.step.task_car;

// Интерфейс для управления автомобилем
interface Drivable {
    void startEngine(Driver driver);

    void stopEngine();

    void drive();
}
