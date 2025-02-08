package com.zsidek;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private final List<Item> firstlist = new ArrayList<>();
    private final List<Item> secondList = new ArrayList<>();

    public void addItemToFirstList(Item item) {
        this.firstlist.add(item);
    }

    public void addItemToSecondList(Item item) {
        this.secondList.add(item);
    }

    public void compareLists() {

    }

}
