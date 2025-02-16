package com.zsidek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Market {
    private final List<Item> firstlist = new ArrayList<>();
    private final List<Item> secondList = new ArrayList<>();
    static final Set<Item> bigList = new HashSet<>();

    public void addItemToFirstList(Item item) {
        this.firstlist.add(item);
        bigList.add(item);
    }

    public void addItemToSecondList(Item item) {
        this.secondList.add(item);
        bigList.add(item);
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

        secondList.stream()
                .filter(firstlist::contains)
                .toList().forEach(bigList::remove);

        StringBuilder differences = new StringBuilder();
        for (Item item1 : distinctFromList1) {
            for (Item item2 : distinctFromList2) {
                differences.append(item1.getDifferences(item2));
            }
        }
        differences.append("\nNot recognized items:\n");
        for (Item item1 : getBigList()) {
            differences.append(item1).append("\n");
        }
        return differences.toString();
    }

    private Set<Item> getBigList() {
        return bigList;
    }

}
