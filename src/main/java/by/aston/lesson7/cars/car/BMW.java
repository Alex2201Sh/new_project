package by.aston.lesson7.cars.car;

import by.aston.lesson7.cars.DriverLicense;

import java.util.ArrayList;

public class BMW extends Car {

    public BMW(int PIN_CODE, DriverLicense carDriverLicense, int seats, ArrayList<Tyre> tyres, Engine engine) {
        super(PIN_CODE, carDriverLicense, seats, tyres, engine);
    }

    @Override
    public void drive() {
        System.out.println("Едем на BMW");
    }
}
