package by.aston.lesson7.cars.driver;

public class DriverKey {
    private final int PIN_CODE;
    private String carManufacturer;

    public DriverKey(int pinCode) {
        PIN_CODE = pinCode;
    }

    public int getPIN_CODE() {
        return PIN_CODE;
    }

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }
}
