package by.aston.lesson7.cars.car;

import by.aston.lesson7.cars.DriverLicense;

import java.util.ArrayList;

public class Tesla extends Car implements Rechargable{

    protected Tesla(int pinCode) {
        super(pinCode);
    }

    public Tesla(int PIN_CODE, DriverLicense carDriverLicense, int seats, ArrayList<Tyre> tyres, Engine engine) {
        super(PIN_CODE, carDriverLicense, seats, tyres, engine);
    }

    @Override
    public void drive() {

    }

    @Override
    public void recharge(int kilowatts) {

    }
}
