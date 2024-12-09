package by.aston.lesson7.cars.driver;

import by.aston.lesson7.cars.DriverLicense;

import java.util.ArrayList;

public class Driver {
    private int experience;
    private ArrayList<DriverLicense> driverLicenses;
    private ArrayList<DriverKey> keyArrayList;

    public Driver(int experience, ArrayList<DriverLicense> driverLicenses, ArrayList<DriverKey> keyArrayList) {
        this.experience = experience;
        this.driverLicenses = driverLicenses;
        this.keyArrayList = keyArrayList;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public ArrayList<DriverLicense> getDriverLicenses() {
        return driverLicenses;
    }

    public void setDriverLicenses(ArrayList<DriverLicense> driverLicenses) {
        this.driverLicenses = driverLicenses;
    }

    public ArrayList<DriverKey> getKeyArrayList() {
        return keyArrayList;
    }

    public void setKeyArrayList(ArrayList<DriverKey> keyArrayList) {
        this.keyArrayList = keyArrayList;
    }
}
