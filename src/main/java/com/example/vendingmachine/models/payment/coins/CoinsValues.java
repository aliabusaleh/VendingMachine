package com.example.vendingmachine.models.payment.coins;

/*
 * this enum  class used for the coins inserted in the coin slot,
 * it also contains the constructor for the coins and getter.
 */



public enum CoinsValues {
    TEN_CENT(1), TWENTY_CENT(2), FIFTY_CENT(5), ONE_DOLLER(10);

    private final double value;

    CoinsValues(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
