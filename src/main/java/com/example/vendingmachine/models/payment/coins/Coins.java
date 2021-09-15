package com.example.vendingmachine.models.payment.coins;


import com.example.vendingmachine.models.payment.Cash;
import com.example.vendingmachine.models.payment.IMoney;

public class Coins extends Cash implements IMoney {

    public Coins(CoinsValues value) {
     super.setValue(value.getValue());
     super.currency = "USD";
     super.EnumValue = value.toString();
    }



}