/*
 * Copyright (c) of Daniel Ashcroft.
 */

package ex1Cars.model.MyCarUtil;

import ex1Cars.model.MyCar;

/**
 * <h1>Car class for testing without the jar file.</h1>
 * <p>Not used. Class of make, model, registration number, and year of manufacture. Implements Comparable and Serializable.</p>
 */
public abstract class Car implements Comparable, java.io.Serializable{
    private String make,model, registrationNumber, yearOfManufacture;

    public Car(String make, String model, String registrationNumber, String yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.yearOfManufacture = yearOfManufacture;
    }



    public String getMake() {
        return make;
    }
    /**
     * <p>Implemented from the <b>Comparable</b> interface</p>
     * @param o Object
     * @return -1 if less, 1 of bigger than, 0 if same
     */
    public int compareTo(Object o){

        String oId = ((Car) o).getRegistrationNumber();

        return this.registrationNumber.compareTo(oId);

    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                '}';
    }
}
