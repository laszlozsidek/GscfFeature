package com.zsidek;

import java.util.Objects;

public class Item {

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

    public String getDifferences(Item item) {
        StringBuilder differences = new StringBuilder();
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
        return differences.toString();
    }
}
