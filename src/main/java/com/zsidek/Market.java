package com.zsidek;

import java.util.ArrayList;
import java.util.HashSet;
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

    public boolean compareLists() {
        return new HashSet<>(firstlist)
                .equals(new HashSet<>(secondList));
    }

    public String logDifferentItemsInLists() {
        List<Item> distinctFromList1 = firstlist.stream()
                .filter(element -> !secondList.contains(element))
                .toList();

        List<Item> distinctFromList2 = secondList.stream()
                .filter(element -> !firstlist.contains(element))
                .toList();

        StringBuilder differences = new StringBuilder();
        for (Item item1 : distinctFromList1) {
            for (Item item2 : distinctFromList2) {
                if (item1.getItemName().equals(item2.getItemName())) {
                    differences.append(item1.getDifferences(item2));
                }
            }
        }
        return differences.toString();
    }
}
