/*
 * Created by Daniel Ashcroft.
 */

package ex1Cars.controller;

import ex1Cars.model.MyCar;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * @author Daniel Ashcroft
 *
 */
public class CarFileController implements Serializable{
    //private static final String FILE_PATH = "C:\\Users\\Dashc\\IdeaProjects\\object_oriented_programming\\assignment2\\src\\ex1Cars\\model\\carsFile.txt";

    public String readString(String FILE_PATH) {
        //filePath = "C:\\Users\\Dashc\\IdeaProjects\\object_oriented_programming\\assignment1\\src\\application\\model\\prizes.txt";
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get(FILE_PATH)));

        } catch (Exception e) {
            System.out.println("!!!!File not found!!!!");
        }

        return data;

    }

    public String[] readList(String FILE_PATH,String delimiter){

        String data = readString(FILE_PATH);

        String[] dataItems = data.split(delimiter);

        return dataItems;
    }

    public void write(String FILE_PATH, LinkedList<MyCar> myCars){
        File file = new File("src\\ex1Cars\\model\\test.txt");
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write("Something");

            output.close();
        } catch (IOException e){
            System.out.println("File not Found!");
        }

    }


}
