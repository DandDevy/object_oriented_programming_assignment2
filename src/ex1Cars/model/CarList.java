/*
 * Created by Daniel Ashcroft.
 */

package ex1Cars.model;

import ex1Cars.controller.CarSerializationController;
//import ex1Cars.model.MyCarUtil.SortCarListByNature;
//import ex1Cars.model.MyCarUtil.SortCarListByYear;
import ex1Cars.model.MyCarUtil.SortMyCarListByMillage;
import util.SortCarListByNature;
import util.SortCarListByYear;

import java.util.Collections;
import java.util.LinkedList;

/**
 * <h1>CarList</h1>
 *
 * <p>A dynamic list of myCars</p>
 * <p> I used <a hef= "https://www.mkyong.com/java/how-to-read-and-write-java-object-to-a-file">how-to-read-and-write-java-object-to-a-file</a></p>
 *
 * https://www.mkyong.com/java/how-to-read-and-write-java-object-to-a-file/
 */
public class CarList  implements java.io.Serializable{

    private LinkedList<MyCar> myCars;
//    private CarFileController carFileController;
    private String[] fileData;
    private static final String FILE_PATH = "src\\ex1Cars\\model\\carsFile.txt";
    private static final String FILE_DELIMITER = "\\.";
    private CarSerializationController serializationController;
    private static final long serialVersionUID = 1L;

    public CarList(int i){

    }

    public CarList() {

        myCars = new LinkedList<MyCar>();

        //get serialized list from file and add to this
       // serializationController = new CarSerializationController();
        //CarList cl = serializationController.read(FILE_PATH);
        //System.out.println("The .ser file has: " + cl);
//
//        int clLength = cl.size();

//        for(int i = 0; i < clLength; i++){
//            this.add(cl.get(i));
//        }

//        carFileController = new CarFileController();

//        fileData = carFileController.readList(FILE_PATH, FILE_DELIMITER);

//        for (int i = 0; i < fileData.length; i+=5) {
//            //System.out.println(fileData[i]);
//            MyCar car = new MyCar(fileData[i], fileData[i+1], fileData[i+2], fileData[i+3], fileData[i+4]);
//            myCars.add(car);
//        }




    }

    /**
     * <p>This method <i>sorts</i> the myCars is order of <b>year of manufacture</b>. If the year(s) of myCars aren't numeric, it will warn by console.</p>
     */
    public void sortByYear(){
        try {
            Collections.sort(myCars, new SortCarListByYear());

        } catch (NumberFormatException e){
            System.out.println("\n\n\n----------------   ERROR: years' of myCars are empty String   -------------------\n\n\n");
        }

    }

    /**
     * <p>Sorts by nature meaning that it will sort first by make, then if myCars have same make, it will compare by model.</p>
     */
    public void sortByNature(){
        try {
            Collections.sort(myCars, new SortCarListByNature());
        } catch (NullPointerException e){
            System.out.println("\n\n\n----------------   ERROR: models' or makes' of myCars are empty String   -------------------\n\n\n");
        }


    }

    /**
     * <p>Sorts my millage</p>
     */
    public void sortByMillage(){
        try {
            Collections.sort(myCars, new SortMyCarListByMillage());

        } catch (NumberFormatException e){
            System.out.println("\n\n\n----------------   ERROR: millages' of myCars are empty String   -------------------\n\n\n");
        }

    }

    /**
     *
     * @return number of myCars
     */
    public int size(){
        return myCars.size();
    }

    /**
     * get car by index
     * @param index
     * @return car
     */
    public MyCar get(int index){
        return myCars.get(index);
    }

    /**
     * <p>Adds myCar to myCar list if it's registration number is unique</p>
     * @param myCar
     */
    public void add(MyCar myCar){
        int size = myCars.size();
        boolean carNotPresent = true;

        for(int i = 0; i < size; i++){
            try {
                if (myCars.get(i).compareTo(myCar) == 0) {
                    carNotPresent = false;
                    System.out.println("ERROR, myCar already exists!!!");
                }
            }catch (NullPointerException e){
                System.out.println("\n\n\n----------------   ERROR: models' or makes' of myCars are empty String   -------------------\n\n\n");
            }
        }

        if(carNotPresent) {
            myCars.add(myCar);
        }
    }

    /**
     * <p>Removes a car by index</p>
     * @param index
     */
    public void remove(int index){
        if(0 < index && index <= myCars.size() ) {
            myCars.remove(index);
        }
    }

    /**
     * <p>removes car by ID/registration number</p>
     * @param id
     */
    public void removeByID(String id){
        int size = myCars.size();
        for(int i = 0; i < size; i++){
            if(id.equals(myCars.get(i).getRegistrationNumber())){
                myCars.remove(i);
                break;
            }
        }
    }

    /**
     * <p>calls the serialization controller to serialize itself</p>
     */
    public void write(){
        serializationController.write(this);
    }

    @Override
    public String toString() {
        return "CarList{" +
                "myCars=" + myCars +
                '}';
    }
}
