/*
 * Created by Daniel Ashcroft.
 */

package ex1Cars.controller;

import ex1Cars.model.CarList;

import java.io.*;

/**
 * <h1>Serializes CarList to a .ser file</h1>
 */
public class CarSerializationController {
    /**
     * https://www.tutorialspoint.com/java/java_serialization.htm
     * used to create this controller
     */


    /**
     * <p>Will write to the CarsFile.ser in the model package</p>
     * @param list
     */
    public void write(CarList list){

        try {
            FileOutputStream fileOut = new FileOutputStream("src\\ex1Cars\\model\\CarsFile.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
            System.out.printf("Serialized model is saved in model test.ser \n");
        } catch (IOException i) {
            i.printStackTrace();
        }
//        try {
//            FileInputStream fileIn = new FileInputStream("src\\ex1Cars\\model\\CarsFile.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            list = (CarList) in.readObject();
//
//            System.out.println(list);
//            in.close();
//            fileIn.close();
//        } catch (IOException i) {
//            i.printStackTrace();
//
//        } catch (ClassNotFoundException t) {
//            System.out.println("CarList class not found");
//            t.printStackTrace();
//        }
    }

    /**
     * <p>Reads file</p>
     * @param FILE_PATH
     * @return CarList
     */
    public CarList read(){

        CarList list =new CarList(1);
        try {
            FileInputStream fileIn = new FileInputStream("src\\ex1Cars\\model\\CarsFile.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Serializable o = (Serializable) in.readObject();
            System.out.println("what is inside my serialized file: \n"+o);
            CarList test = (CarList) o;
//            System.out.println("what is inside my serialized file: \n"+test);
//            list = (CarList) in.readObject();//not working

            list = test;
//            System.out.println("what is inside my serialized filee: \n"+list);

//            System.out.println(o);
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException t) {
            System.out.println("CarList class not found");
            t.printStackTrace();
        }

        System.out.println("what list is inside my serialized file: \n"+list);

        return list;

    }
}
