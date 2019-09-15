
/*
 * Created by Daniel Ashcroft.
 */

package ex1Cars.controller;

import ex1Cars.model.MyCar;
import ex1Cars.model.CarList;

public class CarListController {

    public void add(CarList list, String make, String model, String regNum, String millage, String year){

        list.add(new MyCar(make, model, regNum, millage, year));


    }


    public void remove(CarList list, String id){
        list.removeByID(id);
    }

    public void sortByYear(CarList list){

        list.sortByYear();
    }

    public void sortByMillage(CarList list){
        list.sortByMillage();
    }

    public void sortByNature(CarList list){
        list.sortByNature();
    }

    public void save(CarList list){

        list.write();
    }




}
