/*
 * Created by Daniel Ashcroft.
 */


package ex1Cars.view;

import ex1Cars.controller.CarListController;
import ex1Cars.controller.CarSerializationController;
import ex1Cars.model.CarList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * @author Daniel Ashcroft
 * <h1>The content and layout for my javaFx GUI</h1>
 * <p>This is a ContentForGUI that will take user input.</p>
 * This class for the content of a GUI, buttons, text fields,etc.. and it's layout, for the javafx GUI.
 */
public class ContentForGUI {

    //my window
    private Stage window;
    //my layouts
    private HBox addLayout, removeLayout, menuLayout;
    private VBox wholeLayout;
    private TextField makeTextField, modelTextField, regTextField, millageTextField, yearTextField, removeCarField;
    private Button addButton, removeButton, saveButton, sortByNatureButton, sortByYearButton, sortByMillageButton, quitButton, visualVMButton;
    private TextArea textArea;

    private  ArrayList<String> goMad; // for visual VM

    //my list of cars
    private  CarList carList;

    //controllers used
    private CarListController carListController;
    private CarSerializationController serializationController;

    public ContentForGUI(Stage window, CarList carList, CarListController carListController, CarSerializationController serializationController) {
        this.window = window;
        this.carList = carList;
        this.carListController = carListController;
        this.serializationController = serializationController;

        goMad = new ArrayList<String>(); // for visual VM

        addLayout = new HBox(20);
        wholeLayout = new VBox(50);
        removeLayout = new HBox(20);
        menuLayout = new HBox(10);


        makeTextField = new TextField();
        makeTextField.setPromptText("Make");

        modelTextField = new TextField();
        modelTextField.setPromptText("Model");

        regTextField = new TextField();
        regTextField.setPromptText("Registration number");

        millageTextField = new TextField();
        millageTextField.setPromptText("Millage");

        yearTextField = new TextField();
        yearTextField.setPromptText("Year manufactured");

        addButton = new Button("add");

        saveButton = new Button("save");

        sortByNatureButton = new Button("Sort by nature (make, model)");

        sortByYearButton = new Button("Sort by year");

        sortByMillageButton = new Button("Sort by millage");

        quitButton = new Button("Quit");

        visualVMButton = new Button("Crash for visualVM!!");

        textArea = new TextArea();
        textArea.setText(carList.toString());

        removeButton = new Button("remove");

        removeCarField = new TextField();
        removeCarField.setPromptText("Registration Number");


        buttonActions();
        setLayout();

    }

    /**
     * <p>sets actions for the different actions for the buttons.</p>
     */
    private void buttonActions(){
        /**
         * closes window
         */
        quitButton.setOnAction(event -> {
            window.close();
        });

        /**
         * adds car to list wit unique registration number and displays the list
         */
        addButton.setOnAction(event -> {

            String make = makeTextField.getText();
            String model = modelTextField.getText();
            String reg = regTextField.getText();
            String millage = millageTextField.getText();
            String year = yearTextField.getText();

            carListController.add(carList,make, model, reg, millage, year);

            System.out.println(carList);
            textArea.setText(carList.toString());
        });

        /**
         * removes car by registration number and displays resulting list
         */
        removeButton.setOnAction(event -> {
            String id = removeCarField.getText();
            carListController.remove(carList, id);
            System.out.println(carList);
            textArea.setText(carList.toString());
        });

        /**
         * saves list to a serialized file
         * displays to user of successful save
         */
        saveButton.setOnAction(event -> {
//            carListController.save(carList);
            //CarList c2l =serializationController.read("");
            //System.out.println(c2l);
            serializationController.write(carList); //working

            CarList cl =serializationController.read(); //working
//            System.out.println(cl); //working

            textArea.setText(cl.toString() + "\n  --------------------ALL SAVED!!!!-------------------");

        });

        /**
         * sorts the list by year, if possible
         */
        sortByYearButton.setOnAction(event -> {
            carListController.sortByYear(carList);
            textArea.setText(carList.toString());
        });

        /**
         * sorts the list by millage if possible
         */
        sortByMillageButton.setOnAction(event -> {
            carListController.sortByMillage(carList);
            textArea.setText(carList.toString());
        });

        /**
         * sorts the list by make then model
         */
        sortByNatureButton.setOnAction(event -> {
            carListController.sortByNature(carList);
            textArea.setText(carList.toString());
        });

        visualVMButton.setOnAction(event -> {
            goMad = new ArrayList<String>();
            int i =0;
            while (i < 999999999){
                goMad.add("GO MAD");
                i++;
            }
        });
    }

    /**
     * sets up the layouts of the GUI
     */
    private void setLayout(){
        addLayout.getChildren().addAll(addButton,makeTextField,modelTextField,regTextField,millageTextField,yearTextField);
        addLayout.setAlignment(Pos.CENTER);

        removeLayout.getChildren().addAll(removeButton, removeCarField);
        removeLayout.setAlignment(Pos.CENTER);

        menuLayout.getChildren().addAll(saveButton, sortByNatureButton, sortByYearButton, sortByMillageButton, visualVMButton, quitButton);
        menuLayout.setAlignment(Pos.CENTER);

        wholeLayout.getChildren().addAll(addLayout,removeLayout, menuLayout, textArea);
        wholeLayout.setAlignment(Pos.CENTER);

    }

    /**
     *
     * @return VBox of layout
     */
    public VBox getWholeLayout(){
        return wholeLayout;
    }
}

