package com.example.vendingmachine.service.payment;


import com.example.vendingmachine.models.payment.IMoney;
import com.example.vendingmachine.models.payment.coins.Coins;


public class CoinsPayment implements Payment{


    @Override
    public boolean Validate(IMoney money) {
        if(money.getClass() == Coins.class && ((Coins) money).getCurrency() == "USD")
            return true;
        return false;
    }
}
