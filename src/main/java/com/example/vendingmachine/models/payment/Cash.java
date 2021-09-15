package com.example.vendingmachine.models.payment;
/**
 * Money Abstract Class is a common thing between all the Money options, so the commons will be provided here and
 * the child classes will have those fields
* */
public class Cash {
    protected double value; /// the value of the money, it's double since we might support large numbers.
    protected String currency; /// since we are only now supporting the USD, this will be useless, but if we want to support different it will be used.
    protected String EnumValue;
    /**
     * Setters and Getters
     * */

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnumValue() {
        return EnumValue;
    }

}
