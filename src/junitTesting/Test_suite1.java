/*
 * Copyright (c) of Daniel Ashcroft.
 */

package junitTesting;

//import org.junit.*;
import ex1Cars.model.CarList;
import ex1Cars.model.MyCar;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.Car;

import static org.junit.Assert.assertEquals;

public class Test_suite1 {

    @BeforeClass
    public static void beforeClass(){

//        assertEquals(2, new MyCar("sad","asd","asd", "asd", "asd") );

        System.out.println("BeforeClass");
    }

    @Before
    public void before(){
        System.out.println("start of test");
        MyCar mc = new MyCar("sad","asd","asd", "asd", "asd");
    }

    @Test
    public void test1(){
        System.out.println("test1 : test that the Car is added to CarList correctly.");
        CarList list = new CarList();
        MyCar car = new MyCar("q", "1", "e", "r", "asd");
        list.add(car);
        assertEquals(car, list.get(0));
    }

    @Test
    public void test2(){
        System.out.println("test2 : Test the MyCar inherited attribute.");
        assertEquals("sad", new MyCar("sad","asd","asd", "asd", "asd").getMake() );

    }

    @After
    public void after(){
        System.out.println("end of test\n\n");
    }

}
