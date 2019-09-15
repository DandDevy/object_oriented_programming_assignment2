/*
 * Created by Daniel Ashcroft.
 */

package ex1Cars.view;

import ex1Cars.controller.CarListController;
//import ex1Cars.model.MyCar;
import ex1Cars.controller.CarSerializationController;
import ex1Cars.model.CarList;
//import ex1Cars.model.assignment2Jar.*;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import java.io.*;

public class Main extends Application {


    /**
     * <h1>Main</h1>
     * <p>This starts and instantiates the necessary things to use.</p>
     * @author Daniel Ashcroft
     *
     * @studentCode R00168428
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage){

//        final String FILE_PATH = "src\\ex1Cars\\model\\CarsFile.ser";



        //CarList carList = new CarList();//working

        boolean readFileOnStart = true;

        CarSerializationController serializationController = new CarSerializationController(); //working

        CarList carList;

        if(readFileOnStart){
            carList = serializationController.read();//working
        }else {
            carList = new CarList();
        }
//       serializationController.read();//working

        try{
            carList.get(0);
        }catch (Exception e){
            System.out.println("Empty");
            carList = new CarList();
        }
        CarListController carListController = new CarListController();//working

        ContentForGUI wholeLayout = new ContentForGUI(primaryStage, carList, carListController, serializationController);

        primaryStage.setTitle("Daniel Ashcroft");
        primaryStage.setScene(new Scene(wholeLayout.getWholeLayout(), 1000, 500));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
