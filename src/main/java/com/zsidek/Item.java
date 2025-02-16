package com.zsidek;

import java.util.Objects;

public class Item implements Comparable<Item> {

    private final String itemName;
    private final Float price;
    private final String category;

    public Item(String itemName, String price, String category) {
        this.itemName = itemName;
        this.price = Float.valueOf(price);
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public Float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemName, item.itemName) && Objects.equals(price, item.price) && Objects.equals(category, item.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, price, category);
    }

    @Override
    public String toString() {
        return itemName + "(price: " + price + ", category: " + category + ")";
    }

    String getDifferences(Item item) {
        StringBuilder differences = new StringBuilder();
        int compared = this.compareTo(item);
        if (compared >= 0) {
            Market.bigList.remove(this);
            Market.bigList.remove(item);
            differences
                    .append("\n")
                    .append(this.getItemName())
                    .append(" has different\n");
            if (!Objects.equals(this.getPrice(), item.getPrice())) {
                differences.append("\tprice values: ")
                        .append(String.format("%s - %s\n", this.getPrice(), item.getPrice()));
            }
            if (!Objects.equals(this.getCategory(), item.getCategory())) {
                differences.append("\tcategory values: ")
                        .append(String.format("%s - %s\n", this.getCategory(), item.getCategory()));
            }
        } else if (this.getItemName().matches(getRegex(item.getItemName())) || item.getItemName().matches(getRegex(this.getItemName()))) {
            Market.bigList.remove(this);
            Market.bigList.remove(item);
            differences
                    .append(String.format("\n%s and %s may have different name values. Same items?\n", this.getItemName(), item.getItemName()));
        }
        return differences.toString();
    }

    @Override
    public int compareTo(Item item) {
        if (!this.equals(item) && this.getItemName().equals(item.getItemName())) {
            return 1;
        } else if (!this.equals(item)) {
            return -1;
        } else {
            return 0;
        }
    }

    private static String getRegex(String input) {
        StringBuilder regex = new StringBuilder();
        regex.append("\\S?");
        for (int i = 0; i < input.length(); i++) {
            regex.append(input.charAt(i)).append("\\S?");
        }
        return regex.toString();
    }

}
