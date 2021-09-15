package com.example.vendingmachine.models.snacks;


/*
 * this enum  class used for the coins inserted in the coin slot,
 * it also contains the constructor for the coins and getter.
 */

public enum SnacksSupported {
    WRAMPFLAFEL(5.5f), WRAMPFLAFEL2(10f), WRAMPFLAFEL3(12.5f), WRAMPFLAFEL4(20f), WRAMPFLAFEL5(42f);

    private final double price;

    SnacksSupported(double price) {
        this.price = price;
    }

    public double getValue() {
        return price;
    }
}
