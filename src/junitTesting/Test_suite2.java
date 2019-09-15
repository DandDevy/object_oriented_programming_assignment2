/*
 * Created by Daniel Ashcroft.
 */

package junitTesting;

import ex1Cars.controller.CarListController;
import ex1Cars.controller.CarSerializationController;
import ex1Cars.model.CarList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_suite2 {

    @BeforeClass
    public static void beforeClass(){
        CarList list = new CarList();
    }

    @Test
    public void test1(){
        CarList list = new CarList();
        CarListController controller = new CarListController();
                controller.add(list, "asd", "asd", "asd", "asd", "asd");
    }

    @Test
    public void test2(){
        CarList list = new CarList();
        CarListController controller = new CarListController();
        controller.add(list, "asd", "asd", "asd", "asd", "asd");
        controller.add(list, "asd", "asd", "ad", "asd", "asd");
    }

    @Test
    public void test3(){
        CarSerializationController serializationController = new CarSerializationController();
        CarList carList = serializationController.read();
//        System.out.print(carList);
    }
}
