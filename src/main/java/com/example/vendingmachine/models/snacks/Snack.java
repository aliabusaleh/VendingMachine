package com.example.vendingmachine.models.snacks;


public class Snack {
    private SnacksSupported snackType;
    //index in vending machine.
    private int itemIndex;
    private double price;

    public Snack(SnacksSupported snackType) {
        this.snackType = snackType;
        this.itemIndex = snackType.ordinal();

    }

    public SnacksSupported getSnackType() {
        return snackType;
    }

    public void setSnackType(SnacksSupported snackType) {
        this.snackType = snackType;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
