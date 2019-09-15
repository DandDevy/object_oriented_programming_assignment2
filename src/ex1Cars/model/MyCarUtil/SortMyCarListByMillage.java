/*
 * Copyright (c) of Daniel Ashcroft.
 */

package ex1Cars.model.MyCarUtil;

import ex1Cars.model.MyCar;

import java.util.Comparator;

/**
 * <p>This Class implements Comparator, for Collections.sort to use to compare by Millage</p>
 */
public class SortMyCarListByMillage implements Comparator<MyCar> {

    public int compare(MyCar c1, MyCar c2){

        int millageC1 = Integer.parseInt(c1.getMillage());
        int millageC2 = Integer.parseInt(c2.getMillage());

        return millageC1 - millageC2;
    }
}
