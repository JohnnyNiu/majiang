package com.majiang.scorecalculator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaomingniu on 31/10/15.
 */
public class MenItems {
    private List<MenItem> menItems;

    public MenItems() {
        menItems = new ArrayList<>();
    }

    public void add(MenItem item) {
        menItems.add(item);
    }

    public int count(MenItem menItem) {
        return menItems.contains(menItem)?
                (int)menItems.stream().filter(item -> item.equals(menItem)).count() :
                0;
    }

}
