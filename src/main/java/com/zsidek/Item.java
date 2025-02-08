package com.zsidek;

import java.util.Objects;

public class Item {

    private String itemName;
    private Float price;
    private String category;

    public Item(String itemName, String price, String category) {
        this.itemName = itemName;
        this.price = Float.valueOf(price);
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
}
