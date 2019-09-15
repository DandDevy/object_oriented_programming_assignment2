/*
 * Copyright (c) of Daniel Ashcroft.
 */

package ex1Cars.model.MyCarUtil;

import ex1Cars.model.MyCar;

import java.util.Comparator;

/**
 * <h1>Class implementing Comparator to sort CarList by model and make</h1>
 */
public class SortCarListByNature implements Comparator<MyCar> {

    public int compare(MyCar c1, MyCar c2){
        int res = c1.getMake().compareTo(c2.getMake());

        if (res == 0){
            res = c1.getModel().compareTo(c2.getModel());
        }

        return res;
    }

}
