package by.step.task_car;

import java.util.List;

// Класс для конкретного автомобиля (пример)
class Sedan extends Car {
    public Sedan(Engine engine, List<Wheel> wheels, int seats, String licenseCategory, Key correctKey) {
        super(engine, wheels, seats, licenseCategory, correctKey);
    }
}
