package com.zsidek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<String> stringSet = new HashSet<>();

        List<Item> distinctFromList1 = firstlist.stream()
                .filter(element -> !secondList.contains(element))
                .toList();

        List<Item> distinctFromList2 = secondList.stream()
                .filter(element -> !firstlist.contains(element))
                .toList();

        for (Item item1 : distinctFromList1) {
            for (Item item2 : distinctFromList2) {
                if (item1.getItemName().equals(item2.getItemName())) {
                    if (item1.getPrice().equals(item2.getPrice())) {
                        stringSet.add(item1 + " and " + item2 + " have different 'category' values: " + item1.getCategory() + " - " + item2.getCategory());
                    } else {
                        stringSet.add(item1 + " and " + item2 + " have different 'price' values: " + item1.getPrice() + " - " + item2.getPrice());
                    }
                }
                if (item1.getPrice().equals(item2.getPrice())) {
                    if (item1.getCategory().equals(item2.getCategory())) {
                        stringSet.add(item1 + " and " + item2 + " have different 'name' values: " + item1.getItemName() + " - " + item2.getItemName());
                    } else {
                        stringSet.add(item1 + " and " + item2 + " have different 'category' values: " + item1.getCategory() + " - " + item2.getCategory());
                    }
                }
                if (item1.getCategory().equals(item2.getCategory())) {
                    if (item1.getPrice().equals(item2.getPrice())) {
                        stringSet.add(item1 + " and " + item2 + " have different 'name' values: " + item1.getItemName() + " - " + item2.getItemName());
                    } else {
                        stringSet.add(item1 + " and " + item2 + " have different 'price' values: " + item1.getPrice() + " - " + item2.getPrice());
                    }
                }
            }
        }

        return stringSet.toString();
    }
}
