package by.aston.lesson7.cars.car;

import by.aston.lesson7.cars.DriverLicense;
import by.aston.lesson7.cars.driver.Driver;
import by.aston.lesson7.cars.driver.DriverKey;

import java.util.ArrayList;

public abstract class Car implements Drivable {
    private Engine engine;
    private ArrayList<Tyre> tyres;
    private int seats;
    private DriverLicense carDriverLicense;
    private final int PIN_CODE;

    protected Car(int pinCode) {
        PIN_CODE = pinCode;
    }

    public Car(int PIN_CODE, DriverLicense carDriverLicense, int seats, ArrayList<Tyre> tyres, Engine engine) {
        this.PIN_CODE = PIN_CODE;
        this.carDriverLicense = carDriverLicense;
        this.seats = seats;
        this.tyres = tyres;
        this.engine = engine;
    }

    public boolean startCar(Driver driver) {
        boolean result = false;
        boolean containsDriverLicense = driver.getDriverLicenses().contains(carDriverLicense);
        if (containsDriverLicense) {
            if (isDriverHasValidKey(driver)) return true;
        }
        return result;
    }

    private boolean isDriverHasValidKey(Driver driver) {
        ArrayList<DriverKey> driverKeysArrayList = driver.getKeyArrayList();
        for (DriverKey driverKey : driverKeysArrayList) {
            int pinCode = driverKey.getPIN_CODE();
            boolean isKeyValid = pinCode == PIN_CODE;
            if (isKeyValid) return true;
        }
        return false;
    }
}
