/*
 * Created by Daniel Ashcroft.
 */

package ex1Cars.model;


import util.Car;

//import ex1Cars.model.MyCarUtil.Car;

/**
 * @author Daniel Ashcroft
 * <H1>MyCar class</H1>
 * <p>Possesses a make, a model, a registration number, millage and a year of manufacture.</p>
 */
public class MyCar extends Car implements Comparable, java.io.Serializable{
//    private String make,model, registrationNumber, millage, yearOfManufacture;
    private String millage;
    private static final long serialversionUID = 129348938L;


    /**
     * <p>Constructor uses all String. Inherits from Car in the assignment2Jar.jar</p>
     * @param make
     * @param model
     * @param registrationNumber
     * @param millage
     * @param yearOfManufacture
     */
    public MyCar(String make, String model, String registrationNumber, String millage, String yearOfManufacture) {
        super(make, model, registrationNumber, yearOfManufacture);
//        this.make = make;
//        this.model = model;
//        this.registrationNumber = registrationNumber;
        this.millage = millage;
//        this.yearOfManufacture = yearOfManufacture;
    }

    /**
     * <p>returns String of millage</p>
     * @return string of millage
     */
    public String getMillage() {
        return millage;
    }

    /**
     * <p>sets the millage of the car.</p>
     * @param millage
     */
    public void setMillage(String millage) {
        this.millage = millage;
    }

    @Override
    public String toString() {
        return "MyCar{" +
                "make='" + super.getMake() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", registrationNumber='" + super.getRegistrationNumber()+ '\'' +
                ", millage='" + millage + '\'' +
                ", yearOfManufacture='" + super.getYearOfManufacture() + '\'' +
                "}\n";
    }
}
