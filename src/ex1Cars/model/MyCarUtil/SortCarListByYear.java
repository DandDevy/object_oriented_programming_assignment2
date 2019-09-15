/*
 * Copyright (c) of Daniel Ashcroft.
 */

package ex1Cars.model.MyCarUtil;

import ex1Cars.model.MyCar;

import java.util.Comparator;

public class SortCarListByYear implements Comparator<MyCar> {

    public int compare(MyCar c1, MyCar c2){
        int yearC1 = Integer.parseInt(c1.getYearOfManufacture());
        int yearC2 = Integer.parseInt(c2.getYearOfManufacture());
        return yearC1 - yearC2;
    }

}
